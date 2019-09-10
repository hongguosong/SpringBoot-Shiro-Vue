package com.heeexy.example;

import com.heeexy.example.config.security.VertifyHelper;
import com.heeexy.example.dao.CommentMapper;
import com.heeexy.example.model.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyApplicationTest {

//    @Test
//    public void contextLoads() {
////        LicenseVertify vlicense=new LicenseVertify("noryar"); // 项目唯一识别码，对应生成配置文件的subject
////        vlicense.install(System.getProperty("user.dir"));
////        vlicense.vertify();
//
//        VertifyHelper.getInstance().vertify();
//    }

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void sqlTest() {
        Comment c = new Comment();
        c.setArticleId(5);
        c.setName("user");
        c.setContent("真不怎么样");
//        commentMapper.insert(c);
        List<Comment> list = commentMapper.selectAllByArticleId(5);
        System.out.println(list);
    }

}
