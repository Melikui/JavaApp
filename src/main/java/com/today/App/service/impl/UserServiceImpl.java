package com.today.App.service.impl;

import com.today.App.entity.User;
import com.today.App.mapper.UserMapper;
import com.today.App.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public boolean add(User todo) {
        return userMapper.add(todo);
    }

    @Override
    public boolean update(User todo) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}