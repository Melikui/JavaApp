package com.today.App;

import com.today.App.mapper.StudentMapper;
import com.today.App.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectAll() {
        // 查询全部
        List<Student> students = studentMapper.selectAll();
        for (Student stu : students) {
            System.out.println("name:" + stu.getName() + ",age:" + stu.getAge());
        }
    }
}
