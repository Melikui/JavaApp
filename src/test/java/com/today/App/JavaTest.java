package com.today.App;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class JavaTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void jdbcQuery() {
        List<Map<String, Object>> users = jdbcTemplate.queryForList("select * from user ");
        users.forEach(user -> {
            System.out.println(user);
            System.out.println("姓名：" + user.get("name"));
            System.out.println("职位：" + user.get("position"));
        });
    }
}
