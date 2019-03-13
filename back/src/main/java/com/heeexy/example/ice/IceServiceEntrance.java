package com.heeexy.example.ice;

import Ice.ObjectPrx;
import IceStorm.AlreadySubscribed;
import IceStorm.BadQoS;
import IceStorm.TopicPrx;
import com.heeexy.example.ice.subscribe.ClockI;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class IceServiceEntrance extends Ice.Application{

    private static IceServiceEntrance instance = new IceServiceEntrance();

    private IceServiceEntrance () {

    }

    public static IceServiceEntrance getInstance() {
        return instance;
    }

    private Map<TopicPrx, ObjectPrx> topicObjMap;
    private ExecutorService pool = Executors.newFixedThreadPool(20);

    public Ice.Communicator getCommunicator() {
        return communicator();
    }

    class ShutdownHook extends Thread{

        @Override
        public void run() {
            try{
                communicator().destroy();
            }catch (Ice.LocalException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public int run(String[] strings) {

        setInterruptHook(new ShutdownHook());

        topicObjMap = new HashMap<>();
        pool.execute(() -> {
            subscriber();
        });

        shutdownOnInterrupt();
        communicator().waitForShutdown();

        topicObjMap.forEach((topicPrx, objectPrx) -> {
            topicPrx.unsubscribe(objectPrx);
        });

        pool.shutdown();

        return 0;
    }

    private boolean subscriber() {

        IceStorm.TopicManagerPrx  manager = null;
        try {
            manager = IceStorm.TopicManagerPrxHelper.checkedCast(
                    communicator().propertyToProxy("TopicManager.Proxy"));
            if (manager == null) {
                System.err.println("invalid proxy");
                return false;
            }

            Ice.ObjectAdapter adapter = communicator().createObjectAdapter("Clock.Subscriber");
            Ice.ObjectPrx tickSubscribe = adapter.addWithUUID(new ClockI()).ice_oneway();
            adapter.activate();

            //
            // Retrieve the topic.
            //
            IceStorm.TopicPrx tickTopic = null;
            try {
                tickTopic = manager.retrieve("tick");
                tickTopic.subscribeAndGetPublisher(null, tickSubscribe);
                topicObjMap.put(tickTopic, tickSubscribe);
            } catch (IceStorm.NoSuchTopic e) {
                System.err.println(appName() + ": temporary failure, try again.");
            } catch (AlreadySubscribed e) {
                e.printStackTrace();
            } catch (BadQoS e) {
                e.printStackTrace();
            }

        }catch(Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }


    public void waitForShutdown() {
        topicObjMap.forEach((topicPrx, objectPrx) -> {
            topicPrx.unsubscribe(objectPrx);
        });
        communicator().shutdown();
        pool.shutdown();
    }
}
