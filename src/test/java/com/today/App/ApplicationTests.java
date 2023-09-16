package com.today.App;

import com.today.App.mapper.TodoMapper;
import com.today.App.model.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ApplicationTests {
    @Autowired
    private TodoMapper todoMapper;

    @Test
    public void todoSelectTest() {
        // 查询全部
        List<Todo> todos = todoMapper.getList();
        for (Todo item : todos) {
            System.out.println("value:" + item.getValue() + ",brief:" + item.getBrief());
        }
        Todo todo = new Todo();
        todo.setValue("Python");
        todo.setBrief("简洁优雅的语言");
        todoMapper.add(todo);
    }
}

