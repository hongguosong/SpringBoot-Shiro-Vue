package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.CartDao;
import com.heeexy.example.service.CartService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    private CartDao cartDao;

    @Override
    public JSONObject listCart(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = cartDao.countCart(jsonObject);
        List<JSONObject> list = cartDao.listCart(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addCart(JSONObject jsonObject) {
        cartDao.addCart(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteCart(JSONObject jsonObject) {
        cartDao.deleteCart(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateCart(JSONObject jsonObject) {
        cartDao.updateCart(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject addOne(JSONObject jsonObject) {
        cartDao.addOne(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    public JSONObject decOne(JSONObject jsonObject) {
        cartDao.decOne(jsonObject);
        return CommonUtil.successJson();
    }
}
