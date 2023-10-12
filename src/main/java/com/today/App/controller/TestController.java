package com.today.App.controller;

import com.today.App.mapper.StudentMapper;
import com.today.App.util.Result;
import com.today.App.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/header/test")
    public Result getHeaders(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return Result.ok(headers);
    }

    @GetMapping("/get/test")
    public Result getTest(String name, Integer age) {
        System.out.println(name + "----" + age);
        return Result.ok(studentMapper.list());
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
    public Result postTest(User user) {
        System.out.println(user);
        return Result.ok(user);
    }

    @PostMapping("/post/json")
    public Result jsonTest(@RequestBody Map<String, Object> body) {
        System.out.println(body);
        System.out.println(body.get("name"));
        System.out.println(body.get("age"));
        System.out.println(body.get("boy"));
        System.out.println(body.get("address"));
        return Result.ok(body);
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

