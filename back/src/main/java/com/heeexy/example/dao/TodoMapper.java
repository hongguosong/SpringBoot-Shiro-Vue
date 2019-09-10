package com.heeexy.example.dao;

import com.heeexy.example.model.Todo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TodoMapper {
    int insert(Todo record);

    List<Todo> selectAllByName(@Param("name") String name);

    int updateDone(@Param("done") boolean done, @Param("name") String name, @Param("text") String text, @Param("date") String date);

    int updateAllDone(@Param("done") boolean done, @Param("name") String name);

    int deleteByNameAndTextAndDoneAndDate(@Param("name") String name, @Param("text") String text, @Param("done") boolean done, @Param("date") String date);

    int deleteByNameAndDone(@Param("name") String name, @Param("done") boolean done);

    int updateText(@Param("text") String text, @Param("name") String name, @Param("done") boolean done, @Param("date") String date);
}