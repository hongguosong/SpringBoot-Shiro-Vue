package com.heeexy.example.event;

import com.heeexy.example.config.security.VertifyHelper;
import com.heeexy.example.ice.IceThread;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author ALEX
 */
@Component
@Order(value=1) //可以多定义几个类继承ApplicationRunner，然后order分别等于2,3,4,5...这样就会按顺序初始化加载了
public class InitDataListener implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (VertifyHelper.getInstance().vertify()) {
            IceThread iceThread = new IceThread(new String[]{});
            iceThread.start();
        }
    }
}
