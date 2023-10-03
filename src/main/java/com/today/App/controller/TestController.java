package com.today.App.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {
    @GetMapping("/test")
    public Map<String, String> test(@RequestHeader Map<String, String> headers) {
        // System.out.println("headers------:" + headers.values());
        headers.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });
        return headers;
    }
}

