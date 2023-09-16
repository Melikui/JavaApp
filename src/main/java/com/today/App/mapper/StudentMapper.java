package com.today.App.mapper;

import com.today.App.model.Student;

import java.util.List;

public interface StudentMapper {
    List<Student> selectAll();
}