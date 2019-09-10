package com.heeexy.example.dao;

import com.heeexy.example.model.Comment;
import java.util.List;

public interface CommentMapper {
    int insert(Comment record);
    List<Comment> selectAll();
    List<Comment> selectAllByArticleId(Integer articleId);
}