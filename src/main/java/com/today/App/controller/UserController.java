package com.today.App.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/user/{username}")
    public String userInfo(@PathVariable String username) {
        System.out.println("username: " + username);
        return "用户名:" + username;
    }
}

