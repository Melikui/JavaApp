package com.today.App.mapper;

import com.today.App.model.Todo;

import java.util.List;


public interface TodoMapper {
    /**
     * 获取所有用户信息
     */
    List<Todo> getList();

    // 新增用户
    boolean add(Todo todo);

    // 修改用户
    boolean update(Todo todo);

    // 删除用户
    boolean delete(int id);
}
