package com.heeexy.example.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class InitData implements ApplicationListener<ContextRefreshedEvent>{
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //TestService testService = SpringContextHolder.getBean(TestService.class);
        //testService.start();
    }
}
