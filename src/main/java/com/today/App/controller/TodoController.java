package com.today.App.controller;

import com.today.App.util.Result;
import com.today.App.mapper.TodoMapper;
import com.today.App.entity.Todo;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class TodoController {
    private final TodoMapper todoMapper;

    public TodoController(TodoMapper todoMapper) {
        this.todoMapper = todoMapper;
    }

    /**
     * 查询代办列表
     *
     * @return List
     */
    @GetMapping(value = "/todo/list")
    public Result todoList(@RequestHeader Map<String, String> headers) {
        headers.forEach((key, value) -> System.out.println(key + " : " + value));
        return Result.ok(todoMapper.todoList());
    }

    /**
     * 新增待办事项
     *
     * @return boolean
     */
    @PostMapping(value = "/todo/add")
    private Result addTodo(@RequestBody Map<String, String> params) {
        Todo todo = new Todo();
        todo.setTitle(params.get("title"));
        todo.setContent(params.get("content"));
        boolean addResult = todoMapper.addTodo(todo);
        if (addResult) {
            System.out.println("新增成功!");
        }
        return Result.ok(addResult);
    }

    /**
     * 更新待办事项
     *
     * @return boolean
     */
    @PostMapping(value = "/todo/update/{id}")
    private Result updateTodo(@PathVariable int id, @RequestBody Map<String, String> params) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle(params.get("title"));
        todo.setContent(params.get("content"));
        boolean updateResult = todoMapper.updateTodo(todo);
        if (updateResult) {
            System.out.println("ID为--" + id + "--的待办更新成功!");
        }
        return Result.ok(updateResult);
    }

    /**
     * 删除待办事项
     *
     * @return boolean
     */
    @DeleteMapping(value = "/todo/delete/{id}")
    private Result deleteTodo(@PathVariable int id) {
        boolean deleteResult = todoMapper.deleteTodo(id);
        if (deleteResult) {
            System.out.println("ID为--" + id + "--的待办删除成功!");
        }
        return Result.ok(deleteResult);
    }

}
