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
    public void testInsert() {
        // 新增
        studentMapper.insert(new Student("weiz新增", 1, 30));
    }

//    @Test
//    public void testUpdate() {
//        Student student = studentMapper.selectOne(4L);
//        student.setName("weiz修改");
//        student.setSex(0);
//        // 修改
//        studentMapper.update(student);
//    }

    @Test
    public void testSelectOne() {
        // 查询
        Student student = studentMapper.selectOne(13L);
        System.out.println("name:" + student.getName() + ",age:" + student.getAge());
    }

    //
//    @Test
//    public void testDelete() {
//        // 删除
//        studentMapper.delete(4L);
//    }
    @Test
    public void testSelectAll() {
        // 查询
        List<Student> students = studentMapper.selectAll();
        for (Student stu : students) {
            System.out.println("name:" + stu.getName() + ",age:" + stu.getAge());
        }
    }

}
