package com.heeexy.example.service;/*
 * <p>项目名称: SpringBoot-Shiro-Vue </p>
 * <p>包名称: com.heeexy.example.service </p>
 * <p>描述: [类型描述] </p>
 * <p>创建时间: 2019/3/19 </p>
 * <p>公司信息: 苏州鸿然信息科技有限公司</p>
 * @author <a href="mail to: 994662950@qq.com" rel="nofollow">ALEX</a>
 * @version v1.0
 * @update [序号][日期YYYY-MM-DD] [更改人姓名][变更描述]
 */

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.PictureDao;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PictureService {

    @Autowired
    private PictureDao pictureDao;

    // allEntries=true清除所有缓存
    @CacheEvict(value="pictures",allEntries=true)
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addPicture(JSONObject jsonObject) {
        pictureDao.addPicture(jsonObject);
        return CommonUtil.successJson();
    }

    @Cacheable(value = "pictures", key = "targetClass + methodName +#p0")
    public JSONObject listPicture(JSONObject jsonObject) {
        List<JSONObject> list = pictureDao.listPicture(jsonObject);

        JSONObject result = CommonUtil.successJson();
        JSONObject returnData = new JSONObject();
        returnData.put("list", list);
        result.put("returnData", returnData);
        return result;
    }

    @CacheEvict(value="pictures",allEntries=true)
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updatePicture(JSONObject jsonObject) {
        pictureDao.updatePicture(jsonObject);
        return CommonUtil.successJson();
    }

    @CacheEvict(value="pictures",allEntries=true)
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deletePicture(JSONObject jsonObject) {
        pictureDao.deletePicture(jsonObject);
        return CommonUtil.successJson();
    }
}
