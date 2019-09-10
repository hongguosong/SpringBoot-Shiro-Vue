package com.heeexy.example.ice;

import com.heeexy.example.util.SpringContextHolder;
import org.springframework.core.env.Environment;

public class IceThread extends Thread{

    private String[] args;

    public IceThread (String[] args) {
        this.args = args;
    }

    @Override
    public void run() {
        IceServiceEntrance entrance = IceServiceEntrance.getInstance();
        Environment environment = SpringContextHolder.getBean(Environment.class);
        String configClient = environment.getProperty("ice.config.file");
        entrance.main("ClientMonitor", args,configClient);
    }
}
