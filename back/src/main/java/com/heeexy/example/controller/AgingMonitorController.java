package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.AgingLineService;
import com.heeexy.example.dto.AgingLine;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hr-myq on 17-2-7.
 */
@RestController
@RequestMapping("/AgMonitor")
public class AgingMonitorController {
    @Autowired
    private AgingLineService agingLineService;

    @RequestMapping(value = "AgLines", method = RequestMethod.GET)
    public JSONObject getAgLine(@RequestParam(value = "id", required = false, defaultValue = "0") Integer id) throws IOException {
        JSONObject resultObject = CommonUtil.successJson();
        JSONObject returnData = new JSONObject();

        List<AgingLine> listOfAgingLine = agingLineService.list();

        List<AgingLine> result = new ArrayList<>();
        if (id != 0) {
            for (AgingLine agingLine : listOfAgingLine) {
                if (agingLine.getId() == id) {
                    result.add(agingLine);
                    break;
                }
            }
            returnData.put("list", result);
        }
        returnData.put("list", listOfAgingLine);

        resultObject.put("returnData", returnData);
        return resultObject;
    }
}
