package com.today.App.controller;

import com.today.App.service.UserService;
import com.today.App.util.JSONResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api")
@Tag(name = "测试Swagger3", description = "测试Swagger3注解")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{username}")
    public String userInfo(@PathVariable String username) {
        System.out.println("username: " + username);
        return "用户名:" + username;
    }

    @Operation(summary = "测试Swagger3注解方法Get")
    @Parameters({
            @Parameter(name = "id", description = "编码"),
            @Parameter(name = "headerValue", description = "header传送内容")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "请求成功"),
            @ApiResponse(responseCode = "400", description = "请求参数没填好"),
            @ApiResponse(responseCode = "401", description = "没有权限"),
            @ApiResponse(responseCode = "403", description = "禁止访问"),
            @ApiResponse(responseCode = "404", description = "请求路径没有或页面跳转路径不对")
    })
    @GetMapping("/user/list")
    public JSONResult userList() {
        return JSONResult.ok(userService.list());
    }
}

