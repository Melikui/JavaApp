package com.today.App.mapper;

import com.today.App.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();
    Student selectOne(Long id);
    void insert(Student student);
    void update(Student student);
    void delete(Long id);
}