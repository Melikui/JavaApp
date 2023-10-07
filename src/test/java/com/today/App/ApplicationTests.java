package com.today.App;


import com.today.App.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootTest
@Slf4j
class ApplicationTests {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    void contextLoads() {
        User user = new User();
        user.setId(10);
        user.setName("java-test--tt66666");
        mongoTemplate.save(user);
    }
}

