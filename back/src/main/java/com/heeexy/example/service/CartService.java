package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public interface CartService {
    JSONObject listCart(JSONObject jsonObject);
    JSONObject addCart(JSONObject jsonObject);
    JSONObject deleteCart(JSONObject jsonObject);
    JSONObject updateCart(JSONObject jsonObject);
}
