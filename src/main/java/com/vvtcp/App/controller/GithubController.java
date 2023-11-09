package com.vvtcp.App.controller;

import com.vvtcp.App.util.JSONResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
public class GithubController {
    @GetMapping("/github")
    public JSONResult userInfo(String username) {
        if (username.isEmpty()) {
            return JSONResult.error("用户名不能为空！");
        } else {
            String url = "https://api.github.com/search/users?q={keyword}";
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("keyword", username);
            RestTemplate restTemplate = new RestTemplate();
            Map<?, ?> result = restTemplate.getForObject(url, Map.class, paramMap);
            log.info("请求结果: {}", result);
            return JSONResult.ok(result);
        }
    }
}
