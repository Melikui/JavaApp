package com.today.App.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class WebController {
    @GetMapping ("/getDemo")
    public String getDemo() {
        return "666 Hello @ Spring Boot! ";
    }

    @PostMapping ("/postDemo")
    public String postDemo() {
        return "Post 请求";
    }
}