package com.mall.service.impl;

import com.mall.converter.UserConverter;
import com.mall.dao.UserMapper;
import com.mall.dto.UserDto;
import com.mall.pojo.User;
import com.mall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author suiguozhen on 19/01/19 13:13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDto getByUsernameAndPassword(String username,String password) {
        return UserConverter.CONVERTER.pojoToDto(userMapper.selectByUsernameAndPassword(username,password));
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public UserDto save(UserDto userDto) {
        User user = UserConverter.CONVERTER.dtoToPojo(userDto);
        userMapper.save(user);
        return UserConverter.CONVERTER.pojoToDto(user);
    }

    @Override
    public UserDto getBySubject(String subject) {
        return UserConverter.CONVERTER.pojoToDto(userMapper.selectBySubject(subject));
    }
}