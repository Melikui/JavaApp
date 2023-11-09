package com.vvtcp.App.service.impl;

import com.vvtcp.App.entity.Todo;
import com.vvtcp.App.mapper.TodoMapper;
import com.vvtcp.App.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    TodoMapper todoMapper;

    @Override
    public List<Todo> todoList() {
        return todoMapper.todoList();
    }

    @Override
    public boolean addTodo(Todo todo) {
        return todoMapper.addTodo(todo);
    }

    @Override
    public boolean updateTodo(Todo todo) {
        return todoMapper.updateTodo(todo);
    }

    @Override
    public boolean deleteTodo(int id) {
        return todoMapper.deleteTodo(id);
    }
}
