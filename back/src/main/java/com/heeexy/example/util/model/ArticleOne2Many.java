package com.heeexy.example.util.model;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.util.model </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/3/25 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Set;

public class ArticleOne2Many extends JSONObject {
//    private Set<String> commentList;
    private List<JSONObject> comments;
}
