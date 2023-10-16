package com.today.App;


import com.today.App.mapper.StudentMapper;
import com.today.App.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class ApplicationTests {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void dataString() {
        List<Student> students = studentMapper.list();
        for (Student student : students) {
            System.out.println("-----" + student.toString());
        }
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

    @Test
    public void testString() {
        ValueOperations<String, Object> operations = redisTemplate.opsForValue();
        // 调用set()方法创建缓存
        operations.set("string", "you");
        // 获取缓存数据
        String value = (String) operations.get("string");
        System.out.println("string value :" + value);
    }

    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        // 调用put()方法创建Hash数据缓存
        hash.put("hash", "test", "hello");
        hash.put("hash", "test", "spring");
        hash.put("hash", "test", "boot");
        // 获取Hash数据
        String value = (String) hash.get("hash", "you");
        System.out.println("hash value :" + value);
    }

    @Test
    public void testList() {
        ListOperations<String, Object> list = redisTemplate.opsForList();
        // 把数据插入到List的左边
        list.leftPush("list", "hello");
        list.leftPush("list", "spring");
        list.leftPush("list", "boot");
        // 从左边取出List中的数据
        String value = (String) list.leftPop("list");
        if (value != null) {
            System.out.println("list value :" + value);
        }
    }

    @Test
    public void testSet() {
        String key = "set";
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        // 在Set中插入数据
        set.add(key, "hello");
        set.add(key, "spring");
        set.add(key, "boot");
        set.add(key, "hello");

        // 调用members()方法判断某个数据
        Set<Object> values = set.members(key);
        if (values != null) {
            for (Object v : values) {
                System.out.println("set value :" + v);
            }
        }
    }
}