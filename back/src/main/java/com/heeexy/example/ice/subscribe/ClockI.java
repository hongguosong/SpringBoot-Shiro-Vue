package com.heeexy.example.ice.subscribe;

import Ice.Current;
import com.heeexy.example.config.common.Constants;
import com.heeexy.example.ice.IceProxyFactory;
import com.heeexy.example.util.SpringContextHolder;
import generated.Demo.HelloPrx;
import generated.Demo._ClockDisp;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class ClockI extends _ClockDisp {

    private SimpMessagingTemplate simpMessagingTemplate = SpringContextHolder.getBean(SimpMessagingTemplate.class);

    @Override
    public void tick(String time, Current __current) {
        System.out.println(time);
        HelloPrx hello = IceProxyFactory.createProxy(Constants.HELLO_PROXY);
        String rt = hello.sayHello( (int) Math.round(Math.random()*100));
        simpMessagingTemplate.convertAndSend("/topic/hello", rt);
        simpMessagingTemplate.convertAndSend("/topic/tick", time);
    }
}
