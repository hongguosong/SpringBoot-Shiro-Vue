package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dto.AlarmCount;
import com.heeexy.example.model.*;
import com.heeexy.example.util.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class TestService extends Thread{

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    private static final String[] STATEM = {"idle","run","down","pm"};

    @Override
    public void run() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Random random = new Random();
        while (true) {
            try{
                Thread.sleep(10000);
                simpMessagingTemplate.convertAndSend("/topic/hello", "hello"+Math.round(Math.random()*100));
                simpMessagingTemplate.convertAndSend("/topic/tick", sdf.format(new Date()));
                Temperature t = new Temperature();
                t.setCh1((int)Math.round(50-Math.random()*5));
                t.setCh2((int)Math.round(50-Math.random()*5));
                t.setCh3((int)Math.round(50-Math.random()*5));
                t.setCh4((int)Math.round(50-Math.random()*5));
                t.setCh5((int)Math.round(50-Math.random()*5));
                t.setCh6((int)Math.round(50-Math.random()*5));
                t.setCh7((int)Math.round(50-Math.random()*5));
                t.setCh8((int)Math.round(50-Math.random()*5));
                t.setCh9((int)Math.round(50-Math.random()*5));
                t.setCh10((int)Math.round(50-Math.random()*5));
                t.setCh11((int)Math.round(50-Math.random()*5));
                t.setCh12((int)Math.round(50-Math.random()*5));
                t.setClch1((int)Math.round(20+Math.random()*5));
                t.setClch2((int)Math.round(20+Math.random()*5));
                simpMessagingTemplate.convertAndSend("/topic/temperature", t);

                Yield yield = new Yield((int)Math.round(Math.random()*100), (int)Math.round(Math.random()*100));
                simpMessagingTemplate.convertAndSend("/topic/yield", yield);

                TactTime tactTime = new TactTime();
                tactTime.setAssy((int)Math.round(Math.random()*100)+20);
                tactTime.setFusing((int)Math.round(Math.random()*100)+20);
                tactTime.setAoi((int)Math.round(Math.random()*100)+20);
                tactTime.setAgingIn((int)Math.round(Math.random()*100)+20);
                tactTime.setAgingOut((int)Math.round(Math.random()*100)+20);
                tactTime.setAgingInsp((int)Math.round(Math.random()*100)+20);
                tactTime.setAoi01((int)Math.round(Math.random()*100)+20);
                tactTime.setAoi02((int)Math.round(Math.random()*100)+20);
                tactTime.setFt((int)Math.round(Math.random()*100)+20);
                simpMessagingTemplate.convertAndSend("/topic/tacttime", tactTime);

                Alarm alarm = new Alarm();
                alarm.setId((int)Math.round(Math.random()*10));
                alarm.setUnit("FT");
                alarm.setDesc("div up over time");
                alarm.setStart(sdf.format(new Date()));
                alarm.setEnd(sdf.format(new Date()));
                simpMessagingTemplate.convertAndSend("/topic/alarm", alarm);

                Random r = new Random();
                AlarmCount alarmCount = new AlarmCount();
                alarmCount.setId(r.nextInt(12)+8);
                alarmCount.setCount(r.nextInt(22));
                simpMessagingTemplate.convertAndSend("/topic/alarmCount", alarmCount);

                Count c = new Count();
                c.setTotalPanels(random.nextInt(200)+200);
                c.setAgingPanels(random.nextInt(200));
                c.setCompletedPallets(random.nextInt(100));
                c.setProcessPallets(random.nextInt(100));
                c.setEmptyPallets(random.nextInt(200));
                c.setOvertimePallets(random.nextInt(100));
                c.setAgingPallets(c.getCompletedPallets()+c.getEmptyPallets()+c.getOvertimePallets()+c.getProcessPallets());
                c.setTotalPallets(random.nextInt(200)+c.getAgingPallets());
                simpMessagingTemplate.convertAndSend("/topic/counter", c);

                com.heeexy.example.model.State s = new com.heeexy.example.model.State();
                s.setAssy(STATEM[random.nextInt(4)]);
                s.setFusing(STATEM[random.nextInt(4)]);
                s.setAging(STATEM[random.nextInt(4)]);
                s.setAgingInsp(STATEM[random.nextInt(4)]);
                s.setAoi(STATEM[random.nextInt(4)]);
                s.setAoi01(STATEM[random.nextInt(4)]);
                s.setAoi02(STATEM[random.nextInt(4)]);
                simpMessagingTemplate.convertAndSend("/topic/statem", s);

                Connection connection = new Connection();
                connection.setId("ft8PC");
                connection.setCon(1);
                connection.setTime(0);
                simpMessagingTemplate.convertAndSend("/topic/connections", connection);
                connection.setId("agPLC");
                connection.setCon(1);
                connection.setTime(random.nextDouble());
                simpMessagingTemplate.convertAndSend("/topic/connections", connection);

            } catch (Exception e) {

            }

        }
    }
}
