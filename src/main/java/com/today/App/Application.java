package com.today.App;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.today.App")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

