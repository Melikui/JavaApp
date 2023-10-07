package com.today.App;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void dataString() {
        redisTemplate.opsForValue().set("username", "melikui");
        Object result = redisTemplate.opsForValue().get("username");
        System.out.println(result);
    }
}

