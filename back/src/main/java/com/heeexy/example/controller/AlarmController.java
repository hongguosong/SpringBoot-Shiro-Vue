package com.heeexy.example.controller;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.controller </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/7/2 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.AlarmService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/AgAlarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @RequestMapping(value = "getCurrentAlarm", method = RequestMethod.GET)
    public JSONObject getCurrentAlarm(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        JSONObject resultObject = CommonUtil.successJson();
        JSONObject returnData = new JSONObject();

        returnData.put("list", alarmService.getCurrentAlarmList(id));
        resultObject.put("returnData", returnData);

        return resultObject;
    }
}
