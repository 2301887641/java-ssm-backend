package com.mall.service.impl;

import com.mall.converter.UserConverter;
import com.mall.dao.UserMapper;
import com.mall.dto.UserDto;
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
    public UserDto getByUsernameAndPassword(String username,String password) {
        return UserConverter.converter.pojoToDto(userMapper.selectByUsernameAndPassword(username,password));
    }

    @Override
    public int save(UserDto userDto) {
        return userMapper.insert(UserConverter.converter.dtoToPojo(userDto));
    }

    @Override
    public UserDto getBySubject(String subject) {
        return UserConverter.converter.pojoToDto(userMapper.selectBySubject(subject));
    }
}