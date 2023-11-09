package com.vvtcp.App.service.impl;

import com.vvtcp.App.entity.User;
import com.vvtcp.App.mapper.UserMapper;
import com.vvtcp.App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    public boolean add(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
