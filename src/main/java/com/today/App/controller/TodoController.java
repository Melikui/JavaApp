package com.today.App.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    /**
     * 代办列表
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(@RequestParam("id") String id) {
        System.out.println("todo_id:" + id);
        return "todo_id:" + id;
    }

    /**
     * 新增待办事项
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    private String add(@RequestBody String bodyData) {
        System.out.println("jsonString:" + bodyData);
        return "jsonString:" + bodyData;
    }
}
