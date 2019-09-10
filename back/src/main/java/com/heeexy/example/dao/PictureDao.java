package com.heeexy.example.dao;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.dao </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/3/19 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface PictureDao {
    /**
     * 新增图片
     * @param jsonObject
     * @return
     */
    int addPicture(JSONObject jsonObject);

    /**
     * 图片列表
     *
     * @param jsonObject
     * @return
     */
    List<JSONObject> listPicture(JSONObject jsonObject);

    /**
     * 更新图片描述
     *
     * @param jsonObject
     * @return
     */
    int updatePicture(JSONObject jsonObject);

    /**
     *删除图片
     * @param jsonObject
     * @return
     */
    int deletePicture(JSONObject jsonObject);
}
