package com.heeexy.example.service;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.model.Comment;

/**
 * @author: hxy
 * @date: 2017/10/24 16:06
 */
public interface ArticleService {
    /**
     * 新增文章
     *
     * @param jsonObject
     * @return
     */
    JSONObject addArticle(JSONObject jsonObject);
    int insert(Comment record);
    /**
     * 文章列表
     *
     * @param jsonObject
     * @return
     */
    JSONObject listArticle(JSONObject jsonObject);

    JSONObject getArticleById(Integer id);

    /**
     * 更新文章
     *
     * @param jsonObject
     * @return
     */
    JSONObject updateArticle(JSONObject jsonObject);

    /**
     * 删除文章
     * @param jsonObject
     * @return
     */
    JSONObject deleteArticle(JSONObject jsonObject);
}
