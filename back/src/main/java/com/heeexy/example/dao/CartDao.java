package com.heeexy.example.dao;

import com.alibaba.fastjson.JSONObject;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartDao {

    List<JSONObject> listCart(JSONObject jsonObject);
    int countCart(JSONObject jsonObject);
    int addCart(JSONObject jsonObject);
    int deleteCart(JSONObject jsonObject);
    int updateCart(JSONObject jsonObject);

}
