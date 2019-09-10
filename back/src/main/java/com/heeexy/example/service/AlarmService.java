package com.heeexy.example.service;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.service </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/7/2 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.heeexy.example.model.Alarm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

@Service
public class AlarmService {
    private Logger logger = LoggerFactory.getLogger(AgingLineService.class);

    public List<Alarm> getCurrentAlarmList(int id) {

        List<Alarm> list = new ArrayList<>();

        Alarm alarm = new Alarm();
        alarm.setId(id);
        alarm.setCode("34567");
        alarm.setStart("2018-09-08 12:04:34");
        alarm.setUnit("FT");
        alarm.setDesc("IN DIV DOWN OVET TIME");

        Alarm alarm2 = new Alarm();
        alarm2.setId(id);
        alarm2.setCode("34568");
        alarm2.setStart("2018-09-08 14:04:34");
        alarm2.setUnit("AT");
        alarm2.setDesc("OUT DIV UP OVET TIME");

        if(Math.random() > 0.5) {
            list.add(alarm);
            list.add(alarm2);
        }

        return list;
    }
}
