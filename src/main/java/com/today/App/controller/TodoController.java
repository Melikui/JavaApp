package com.today.App.controller;

import com.today.App.mapper.TodoMapper;
import com.today.App.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {
    @Autowired
    private TodoMapper todoMapper;

    @GetMapping(value = "/todo/list")
    public List<Todo> list(@RequestParam("id") String id) {
        List<Todo> todos = todoMapper.getList();
        for (Todo item : todos) {
            System.out.println(item);
        }
        System.out.println("todo_id:" + id);
        return todos;
    }

    @PostMapping(value = "/todo/add")
    private String add(@RequestBody String bodyData) {
        System.out.println("jsonString:" + bodyData);
        return "jsonString:" + bodyData;
    }

}
