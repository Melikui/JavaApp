package com.vvtcp.App.mapper;

import com.vvtcp.App.entity.User;

import java.util.List;

public interface UserMapper {

    // 查询用户列表
    List<User> list();

    // 新增用户
    boolean addUser(User user);

    // 修改用户
    boolean updateUser(User user);

    // 删除用户
    boolean deleteUser(int id);

}

