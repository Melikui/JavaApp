package com.today.App.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
@RestController
@RequestMapping("/api")
public class GithubController {
    @GetMapping("/github/{user}")
    public Map<?,?> userInfo(@PathVariable String user) {
        String url = "https://api.github.com/search/users?q={keyword}";
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("keyword", user);
        RestTemplate restTemplate = new RestTemplate();
        Map<?,?> result = restTemplate.getForObject(url, Map.class, paramMap);
        System.out.println("请求结果: " + result);
        return result;
    }
}
