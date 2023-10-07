package com.today.App;


import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.HashMap;

@SpringBootTest
@Slf4j
class ApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void dataString() {
        // 1、存数据
        redisTemplate.opsForValue().set("username", "melikui");
        // 2、取数据
        Object result = redisTemplate.opsForValue().get("username");
        System.out.println(result);
    }

    @Test
    public void dataHash() {
        // 1、写数据
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("key1", "value1");
        hashMap.put("key2", "value2");
        redisTemplate.opsForHash().putAll("data-hash", hashMap);
        // 2、读数据
        Object kv1 = redisTemplate.opsForHash().get("data-hash", "key1");
        Object kv2 = redisTemplate.opsForHash().get("data-hash", "key2");
        System.out.println("kv1---" + kv1);
        System.out.println("kv2---" + kv2);
    }
}

