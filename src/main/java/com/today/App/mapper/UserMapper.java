package com.today.App.mapper;

import com.today.App.model.User;

import java.util.List;

public interface UserMapper {
    /**
     * 获取所有用户信息
     * @return
     */
    List<User> getAll();

}

