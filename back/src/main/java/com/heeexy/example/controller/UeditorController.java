package com.heeexy.example.controller;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.controller </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/3/15 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.config.common.Constants;
import com.heeexy.example.ueditor.ActionEnter;
import com.heeexy.example.util.CommonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@RestController
@CrossOrigin
@RequestMapping("/sys/ueditor")
public class UeditorController{

    private Logger log = LoggerFactory.getLogger(UeditorController.class);
    @RequestMapping(value = "/exec")
    @ResponseBody
    public String exec(HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        String rootPath = request.getRealPath("/");
        return new ActionEnter( request, rootPath).exec();
    }
}
