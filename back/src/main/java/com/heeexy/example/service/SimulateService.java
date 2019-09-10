package com.heeexy.example.service;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.service </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/4/10 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.heeexy.example.model.Action;
import com.heeexy.example.model.Pallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class SimulateService{
    private boolean START = true;
    private Timer timer = new Timer(true);

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    public void clear(int a, int b, int c) {
        simpMessagingTemplate.convertAndSend("/topic/simulate", new Action(a,b,c,0,0,0,0,0));
        simpMessagingTemplate.convertAndSend("/topic/pallet", new Pallet(a,b,c,""));
    }

    public void simulate(int a,int b,int c,int x,int y,int z,int m,int o) {
        simpMessagingTemplate.convertAndSend("/topic/simulate", new Action(a,b,c,x,y,z,m,o));
    }

    public void pallet(int a, int b, int c, String id) {
        simpMessagingTemplate.convertAndSend("/topic/pallet", new Pallet(a,b,c,id));
    }
    public void start () {

        if (START) {
            //START = false;

            simulate(3,4,15,0,-1,0,1,1);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(3,4,15);
                    pallet(2,4,15,"08025");
                    simulate(2,4,15,1,0,0,43,1);
                    simulate(3,4,14,1,0,0,1,1);
                }
            }, 1000);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,15);
                    clear(3,4,14);
                    pallet(3,4,15,"08024");
                    simulate(3,4,15,0,-1,0,1,1);
                    simulate(3,4,13,1,0,0,1,1);

                    pallet(2,4,58,"08025");
                }
            }, 2000);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(3,4,15);
                    pallet(2,4,15,"08024");
                    simulate(2,4,15,1,0,0,42,1);

                    clear(3,4,13);
                    pallet(3,4,14,"08023");
                    simulate(3,4,14,1,0,0,1,1);

                    simulate(3,4,12,1,0,0,1,1);
                }
            }, 3000);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(3,4,14);
                    pallet(3,4,15,"08023");
                    simulate(3,4,15,0,-1,0,1,1);

                    clear(2,4,15);

                    clear(3,4,12);
                    pallet(3,4,13,"08022");
                    simulate(3,4,13,1,0,0,1,1);

                    pallet(2,4,57,"08024");
                }
            }, 4000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(3,4,15);
                    pallet(2,4,15,"08023");
                    simulate(2,4,15,1,0,0,41,1);

                    clear(3,4,13);
                    pallet(3,4,14, "08022");
                    simulate(3,4,14,1,0,0,1,1);
                }
            }, 5000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,15);

                    clear(3,4,14);
                    pallet(3,4,15,"08022");
                    simulate(3,4,15,0,-1,0,1,1);

                    pallet(2,4,56,"08023");
                }
            }, 6000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(3,4,15);
                    pallet(2,4,15,"08022");
                    simulate(2,4,15,1,0,0,40,1);
                }
            }, 7000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,15);
                    pallet(2,4,55,"08022");
                }
            }, 8000);

//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    simulate(2,4,58,1,0,0,1,1);
//                    simulate(2,4,57,1,0,0,1,1);
//                    simulate(2,4,56,1,0,0,1,1);
//                    simulate(2,4,55,1,0,0,1,1);
//                }
//            }, 50000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(2,4,58);
//                    clear(2,4,57);
//                    clear(2,4,56);
//                    clear(2,4,55);
//                    pallet(2,4,59, "08025");
//                    pallet(2,4,58, "08024");
//                    pallet(2,4,57, "08023");
//                    pallet(2,4,56, "08022");
//                    simulate(2,4,59,0,-2,-1,1,1);
//
//                    simulate(2,4,58,1,0,0,1,1);
//                    simulate(2,4,57,1,0,0,1,1);
//                    simulate(2,4,56,1,0,0,1,1);
//                }
//            }, 50000 + 1000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(2,4,59);
//                    pallet(0,3,59, "08025");
//                    simulate(0,3,59,1,0,0,30,1);
//
//                    clear(2,4,58);
//                    clear(2,4,57);
//                    clear(2,4,56);
//                    pallet(2,4,59, "08024");
//                    pallet(2,4,58, "08023");
//                    pallet(2,4,57, "08022");
//
//                    simulate(2,4,59,0,-2,-1,1,1);
//
//                    simulate(2,4,58,1,0,0,1,1);
//                    simulate(2,4,57,1,0,0,1,1);
//
//                }
//            }, 50000 + 2000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(0,3,59);
//                    pallet(0,3,89, "08025");
//
//                    clear(2,4,59);
//                    pallet(0,3,59, "08024");
//                    simulate(0,3,59,1,0,0,29,1);
//
//                    clear(2,4,58);
//                    clear(2,4,57);
//                    pallet(2,4,59, "08023");
//                    pallet(2,4,58, "08022");
//
//                    simulate(2,4,59,0,-2,-1,1,1);
//
//                    simulate(2,4,58,1,0,0,1,1);
//                }
//            }, 50000 + 3000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(0,3,59);
//                    pallet(0,3,88, "08024");
//
//                    clear(2,4,59);
//                    pallet(0,3,59, "08023");
//                    simulate(0,3,59,1,0,0,28,1);
//
//                    clear(2,4,58);
//                    pallet(2,4,59, "08022");
//                    simulate(2,4,59,0,-2,-1,1,1);
//                }
//            }, 50000 + 4000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(0, 3 ,59);
//                    pallet(0,3,87,"08023");
//
//                    clear(2,4,59);
//                    pallet(0,3,59,"08022");
//                    simulate(0,3,59,1,0,0,27,1);
//                }
//            }, 50000 + 5000);
//
//            timer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    clear(0, 3 ,59);
//                    pallet(0,3,86,"08022");
//                }
//            }, 50000 + 6000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    simulate(2,4,58,1,0,0,1,1);
                    simulate(2,4,57,1,0,0,1,1);
                    simulate(2,4,56,1,0,0,1,1);
                    simulate(2,4,55,1,0,0,1,1);
                }
            }, 50000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,58);
                    clear(2,4,57);
                    clear(2,4,56);
                    clear(2,4,55);
                    pallet(2,4,59, "08025");
                    pallet(2,4,58, "08024");
                    pallet(2,4,57, "08023");
                    pallet(2,4,56, "08022");
                    simulate(2,4,59,0,-2,-1,1,1);
                }
            }, 50000 + 1000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,59);
                    pallet(0,3,59,"08025");
                    simulate(0,3,59,1,0,0,30,1);
                }
            }, 50000 + 2000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(0,3,59);
                    pallet(0,3,89, "08025");

                    simulate(2,4,58,1,0,0,1,1);
                    simulate(2,4,57,1,0,0,1,1);
                    simulate(2,4,56,1,0,0,1,1);
                }
            }, 50000 + 3000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,58);
                    clear(2,4,57);
                    clear(2,4,56);
                    pallet(2,4,59, "08024");
                    pallet(2,4,58, "08023");
                    pallet(2,4,57, "08022");
                    simulate(2,4,59,0,-2,-1,1,1);
                }
            }, 50000 + 4000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,59);
                    pallet(0,3,59,"08024");
                    simulate(0,3,59,1,0,0,29,1);
                }
            }, 50000 + 5000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(0,3,59);
                    pallet(0,3,88,"08024");

                    simulate(2,4,58,1,0,0,1,1);
                    simulate(2,4,57,1,0,0,1,1);
                }
            }, 50000 + 6000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,58);
                    clear(2,4,57);
                    pallet(2,4,59, "08023");
                    pallet(2,4,58, "08022");

                    simulate(2,4,59,0,-2,-1,1,1);
                }
            }, 50000 + 7000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,59);
                    pallet(0,3,59,"08023");
                    simulate(0,3,59,1,0,0,28,1);
                }
            }, 50000 + 8000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(0,3,59);
                    pallet(0,3,87,"08023");
                    simulate(2,4,58,1,0,0,1,1);
                }
            }, 50000 + 9000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,58);
                    pallet(2,4,59,"08022");
                    simulate(2,4,59,0,-2,-1,1,1);
                }
            }, 50000 + 10000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(2,4,59);
                    pallet(0,3,59,"08022");
                    simulate(0,3,59,1,0,0,27,1);
                }
            }, 50000 + 11000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    clear(0,3,59);
                    pallet(0,3,86,"08022");
                }
            }, 50000 + 12000);
        }
    }
}
