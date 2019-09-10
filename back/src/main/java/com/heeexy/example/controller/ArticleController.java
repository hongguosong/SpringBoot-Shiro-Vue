package com.heeexy.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.model.Comment;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.util.CommonUtil;
import com.heeexy.example.util.StringTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.Date;

import static com.heeexy.example.util.constants.ErrorEnum.E_400;

/**
 * @author: hxy
 * @description: 文章相关Controller
 * @date: 2017/10/24 16:04
 */
@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    /**
     * 查询文章列表
     *
     * @param request
     * @return
     */
    @RequiresPermissions("article:list")
    @GetMapping("/listArticle")
    public JSONObject listArticle(HttpServletRequest request) {
        return articleService.listArticle(CommonUtil.request2Json(request));
    }

    @GetMapping("/getArticleById")
    public JSONObject getArticleById(@RequestParam(value = "id", defaultValue = "0") Integer id) {
        return articleService.getArticleById(id);
    }
    /**
     * 新增文章
     *
     * @param requestJson
     * @return
     */
    @RequiresPermissions("article:add")
    @PostMapping("/addArticle")
    public JSONObject addArticle(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "content");
        return articleService.addArticle(requestJson);
    }

    @PostMapping("/addComment")
    public JSONObject addComment(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "articleId,name,content");
        Comment comment = new Comment();
        comment.setArticleId(requestJson.getInteger("articleId"));
        comment.setName(requestJson.getString("name"));
        comment.setContent(requestJson.getString("content"));
        comment.setCreateTime(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        int r = articleService.insert(comment);
        if(r>0) {
            return CommonUtil.successJson(JSONObject.toJSON(comment));
        } else {
            return CommonUtil.errorJson(E_400);
        }
    }

    /**
     * 修改文章
     *
     * @param requestJson
     * @return
     */
    @RequiresPermissions("article:update")
    @PostMapping("/updateArticle")
    public JSONObject updateArticle(@RequestBody JSONObject requestJson) {
        CommonUtil.hasAllRequired(requestJson, "id,content");
        return articleService.updateArticle(requestJson);
    }

    /**
     * 删除文章
     * @param requestJson
     * @return
     */
    @RequiresPermissions("article:delete")
    @PostMapping("/deleteArticle")
    public JSONObject deleteArticle(@RequestBody JSONObject requestJson) {
        return articleService.deleteArticle(requestJson);
    }
}
