package com.today.App;

import com.today.App.mapper.StudentMapper;
import com.today.App.mapper.UserMapper;
import com.today.App.model.Student;
import com.today.App.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectAll() {
        // 查询全部
        List<User> users = userMapper.getAll();
        for (User u : users) {
            System.out.println("name:" + u.getName() + ",age:" + u.getAge());
        }
    }
}
