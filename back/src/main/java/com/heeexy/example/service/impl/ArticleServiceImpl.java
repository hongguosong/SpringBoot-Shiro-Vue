package com.heeexy.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heeexy.example.dao.ArticleDao;
import com.heeexy.example.dao.CommentMapper;
import com.heeexy.example.model.Comment;
import com.heeexy.example.service.ArticleService;
import com.heeexy.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: hxy
 * @description:
 * @date: 2017/10/24 16:07
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 新增文章
     *
     * @param jsonObject
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addArticle(JSONObject jsonObject) {
        articleDao.addArticle(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(Comment record) {
        return commentMapper.insert(record);
    }

    /**
     * 文章列表
     *
     * @param jsonObject
     * @return
     */
    @Override
    public JSONObject listArticle(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = articleDao.countArticle(jsonObject);
        List<JSONObject> list = articleDao.listArticle(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject getArticleById(Integer id) {
        List<JSONObject> d = articleDao.getArticleById(id);
        return CommonUtil.successJson(d);
    }

    /**
     * 更新文章
     *
     * @param jsonObject
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateArticle(JSONObject jsonObject) {
        articleDao.updateArticle(jsonObject);
        return CommonUtil.successJson();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteArticle(JSONObject jsonObject) {
        articleDao.deleteArticle(jsonObject);
        return CommonUtil.successJson();
    }
}
