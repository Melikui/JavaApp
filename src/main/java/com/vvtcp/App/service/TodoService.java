package com.vvtcp.App.service;

import com.vvtcp.App.entity.Todo;

import java.util.List;

public interface TodoService {
    /**
     * 获取所有用户信息
     */
    List<Todo> todoList();

    // 新增用户
    boolean addTodo(Todo todo);

    // 修改用户
    boolean updateTodo(Todo todo);

    // 删除用户
    boolean deleteTodo(int id);
}