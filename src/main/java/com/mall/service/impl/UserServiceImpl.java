package com.mall.service.impl;

import com.mall.common.Result;
import com.mall.dao.UserMapper;
import com.mall.pojo.User;
import com.mall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author suiguozhen on 19/01/19 13:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        return userMapper.selectByUsername(username);
    }
}