package com.today.App.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TodoController {
    @GetMapping(value = "/todo/list")
    public String list(@RequestParam("id") String id) {
        System.out.println("todo_id:" + id);
        return "todo_id:" + id;
    }

    @PostMapping(value = "/todo/add")
    private String add(@RequestBody String bodyData) {
        System.out.println("jsonString:" + bodyData);
        return "jsonString:" + bodyData;
    }
}
