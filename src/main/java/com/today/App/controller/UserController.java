package com.today.App.controller;

import com.today.App.mapper.UserMapper;
import com.today.App.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    private final UserMapper userMapper;

    public UserController(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @GetMapping("/user/{username}")
    public String userInfo(@PathVariable String username) {
        System.out.println("username: " + username);
        return "用户名:" + username;
    }

    @GetMapping("/user/list")
    public List<User> userList() {
        List<User> users = userMapper.list();
        log.info("用户信息: {}",users);
        for (User item : users) {
            System.out.println(item.toString());
        }
        return users;
    }
}

