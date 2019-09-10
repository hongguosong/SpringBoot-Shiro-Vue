package com.heeexy.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.heeexy.example.model.Todo;
import com.heeexy.example.dao.TodoMapper;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoMapper todoDao;

    @RequestMapping(value="/list", method = {RequestMethod.POST, RequestMethod.GET})
    public List<Todo> findAllByName(@RequestParam(value="name") String name){
        return todoDao.selectAllByName(name);
    }

    @RequestMapping(value="add", method = RequestMethod.POST)
    public boolean addTodo(@RequestBody Todo todo){
        boolean result = true;
        try{
            todoDao.insert(todo);
        }catch(Exception e){
            result = false;
        }
        return result;
    }

    @RequestMapping(value="updateDone", method = RequestMethod.POST)
    public boolean updateDone(@RequestBody Todo todo) {
        boolean result = true;
        try{
            int r = todoDao.updateDone(todo.getDone(), todo.getName(), todo.getText(), todo.getDate());
            if(r <= 0){
                result =false;
            }
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    @RequestMapping(value="updateAll", method = RequestMethod.POST)
    public boolean updateAllTodo(@RequestParam(value="done") boolean done, @RequestParam(value = "name") String name) {
        boolean result = true;
        try{
            todoDao.updateAllDone(done, name);
        }catch (Exception e){
            result = false;
        }
        return result;
    }

    @RequestMapping(value="updateText", method = RequestMethod.POST)
    public boolean updateOneTodo(@RequestBody Todo todo) {
        boolean result = true;
        try{
            int r = todoDao.updateText(todo.getText(), todo.getName(), todo.getDone(), todo.getDate());
            if(r <= 0){
                result =false;
            }
        }catch (Exception e) {
            result = false;
        }
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public boolean delete(@RequestBody Todo todo) {
        boolean result = true;
        try{
            todoDao.deleteByNameAndTextAndDoneAndDate(todo.getName(), todo.getText(), todo.getDone(), todo.getDate());
        } catch (Exception e){
            System.out.println(e);
            result = false;
        }
        return  result;
    }

    @RequestMapping(value = "deleteCompleted", method = RequestMethod.POST)
    public boolean deleteCompleted(@RequestParam(value = "name") String name) {
        boolean result = true;
        try{
            todoDao.deleteByNameAndDone(name, true);
        } catch (Exception e){
            System.out.println(e);
            result = false;
        }
        return  result;
    }
}
