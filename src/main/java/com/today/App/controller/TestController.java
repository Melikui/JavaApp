package com.today.App.controller;

import com.today.App.mapper.StudentMapper;
import com.today.App.util.JSONResult;
import com.today.App.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/header/test")
    public JSONResult getHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return JSONResult.ok(headers);
    }

    @GetMapping("/get/test")
    public JSONResult getTest(String name, Integer age) {
        System.out.println(name + "----" + age);
        return JSONResult.ok(studentMapper.list());
    }

    @GetMapping("/get/test1")
    public String getTest1(String name, Integer age) {
        System.out.println(name + "--" + age);
        return "get ok";
    }

    @GetMapping("/date/test")
    public String dateTest(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        System.out.println(date);
        return "get ok";
    }

    @PostMapping("/post/test1")
    public String postTest1(
            @RequestParam(name = "username", required = false) String name,
            Integer age) {
        System.out.println(name + "--" + age);
        return "post ok";
    }

    @PostMapping("/post/test")
    public JSONResult postTest(User user) {
        System.out.println(user);
        throw new RuntimeException("计算错误");
        // return JSONResult.ok(user);
    }

    @PostMapping("/post/json")
    public JSONResult jsonTest(@RequestBody Map<String, Object> body) {
        System.out.println(body);
        System.out.println(body.get("name"));
        System.out.println(body.get("age"));
        System.out.println(body.get("boy"));
        System.out.println(body.get("address"));
        return JSONResult.ok(body);
    }

    @GetMapping("/put/{id}")
    public String valueTest(@PathVariable String id) {
        System.out.println(id);
        return "ok";
    }

    @GetMapping("/put/{id}/{name}")
    public String valuesTest(@PathVariable String id, @PathVariable String name) {
        System.out.println(id + name);
        return "ok";
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

