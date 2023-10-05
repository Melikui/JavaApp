package com.today.App.controller;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public Map<String, String> test(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return headers;
    }
}

