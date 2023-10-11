package com.today.App.controller;

import com.today.App.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    public void jsonResponse() {
    }

    @GetMapping("/header/test")
    public Map<String, String> getHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return headers;
    }

    @GetMapping("/get/test")
    public String getTest(String name, Integer age) {
        System.out.println(name + "----" + age);
        return "get ok";
    }

    @PostMapping("/get/test1")
    public String getTest1(String name, Integer age) {
        System.out.println(name + "--" + age);
        return "post ok";
    }

    @PostMapping("/post/test1")
    public String postTest1(
            @RequestParam(name = "username", required = false) String name,
            Integer age) {
        System.out.println(name + "--" + age);
        return "get ok";
    }
    @PostMapping("/post/test")
    public User postTest(User user) {
        System.out.println(user);
        return user;
    }

    @PutMapping("/put/test")
    public Map<String, String> putTest(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return headers;
    }

    @DeleteMapping("/delete/test")
    public Map<String, String> deleteTest(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return headers;
    }
}

