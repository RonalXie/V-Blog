package com.xsy.service.Impl;

import com.xsy.domain.User;
import com.xsy.mapper.UserMapper;
import com.xsy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(int id) {
        return userMapper.selectByPrimaryKey(id);
    }
}
