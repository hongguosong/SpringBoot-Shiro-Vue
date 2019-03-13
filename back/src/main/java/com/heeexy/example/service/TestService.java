package com.heeexy.example.service;

import com.heeexy.example.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TestService extends Thread{

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        while (true) {
            try{
                Thread.sleep(10000);
                simpMessagingTemplate.convertAndSend("/topic/hello", "hello"+Math.round(Math.random()*100));
                simpMessagingTemplate.convertAndSend("/topic/tick", sdf.format(new Date()));
            } catch (Exception e) {

            }

        }
    }
}
