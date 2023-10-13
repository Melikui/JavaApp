package com.today.App.service;

import com.today.App.entity.User;

import java.util.List;

public interface UserService {
    // 查询用户列表
    List<User> list();

    // 新增用户
    boolean add(User user);

    // 修改用户
    boolean update(User user);

    // 删除用户
    boolean delete(int id);
}
