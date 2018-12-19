package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.service.impl.CartServiceImpl;
import com.heeexy.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartServiceImpl cartService;

    @RequiresPermissions("cart:list")
    @GetMapping("/listCart")
    public JSONObject listCart(HttpServletRequest request) {
        return cartService.listCart(CommonUtil.request2Json(request));
    }

    @RequiresPermissions("cart:add")
    @PostMapping("/addCart")
    public JSONObject addCart(@RequestBody JSONObject jsonObject) {
        return cartService.addCart(jsonObject);
    }

    @RequiresPermissions("cart:update")
    @PostMapping("/updateCart")
    public JSONObject updateCart(@RequestBody JSONObject jsonObject) {
        CommonUtil.hasAllRequired(jsonObject, "id, name, num");
        return cartService.updateCart(jsonObject);
    }

    @RequiresPermissions("cart:delete")
    @PostMapping("/deleteCart")
    public JSONObject deleteCart(@RequestBody JSONObject jsonObject) {
        return cartService.deleteCart(jsonObject);
    }
}
