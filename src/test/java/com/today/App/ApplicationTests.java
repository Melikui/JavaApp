package com.today.App;

import com.today.App.mapper.UserMapper;
import com.today.App.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void userSelectTest() {
        // 查询全部
        List<User> users = userMapper.list();
        for (User item : users) {
            System.out.println(item.toString());
        }
    }
}

