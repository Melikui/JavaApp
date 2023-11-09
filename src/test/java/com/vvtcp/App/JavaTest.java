package com.vvtcp.App;

import com.vvtcp.App.entity.Github;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class JavaTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 测试 jdbc
     */
    @Test
    public void jdbcQuery() {
        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from user ");
        users.forEach(user -> {
            System.out.println(user);
            System.out.println("姓名：" + user.get("name"));
            System.out.println("职位：" + user.get("position"));
        });
    }

    /**
     * 测试 Mongodb
     */
    @Test
    public void findUser() {
        List<Github> users = mongoTemplate.findAll(Github.class);
        for (Github user : users) {
            System.out.println(user);
        }
    }
}
