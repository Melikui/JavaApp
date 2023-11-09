package com.vvtcp.App.controller;

import com.vvtcp.App.service.TodoService;
import com.vvtcp.App.util.JSONResult;
import com.vvtcp.App.entity.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TodoController {

    @Autowired
    TodoService todoService;

    /**
     * 查询代办列表
     *
     * @return List
     */
    @GetMapping(value = "/todo")
    public JSONResult todoList() {
        return JSONResult.ok(todoService.todoList());
    }

    /**
     * 新增待办事项
     *
     * @return boolean
     */
    @PostMapping(value = "/todo")
    private JSONResult addTodo(@RequestBody Map<String, String> params) {
        Todo todo = new Todo();
        todo.setTitle(params.get("title"));
        todo.setContent(params.get("content"));
        boolean addResult = todoService.addTodo(todo);
        if (addResult) {
            System.out.println("新增成功!");
        }
        return JSONResult.ok(addResult);
    }

    /**
     * 更新待办事项
     *
     * @return boolean
     */
    @PutMapping(value = "/todo/{id}")
    private JSONResult updateTodo(
            @PathVariable int id,
            @RequestBody Map<String, String> params,
            @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date
    ) {
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle(params.get("title"));
        todo.setContent(params.get("content"));
        todo.setUpdateTime(date);
        boolean updateResult = todoService.updateTodo(todo);
        if (updateResult) {
            String msg = "ID为--" + id + "--的待办更新成功!";
            System.out.println(msg);
            return JSONResult.ok(msg);
        } else {
            return JSONResult.error("更新失败！");
        }
    }

    /**
     * 删除待办事项
     *
     * @return boolean
     */
    @CrossOrigin(origins = "*")
    @DeleteMapping(value = "/todo/{id}")
    private JSONResult deleteTodo(@PathVariable int id) {
        boolean deleteResult = todoService.deleteTodo(id);
        if (deleteResult) {
            String msg = "ID为--" + id + "--的待办删除成功!";
            System.out.println(msg);
            return JSONResult.ok(msg);
        } else {
            return JSONResult.error("删除失败！");
        }
    }
}
