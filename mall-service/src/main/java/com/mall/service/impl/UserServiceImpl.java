package com.mall.service.impl;


import com.mall.core.context.SpringUtil;
import com.mall.core.exception.BusinessException;
import com.mall.dao.mapper.UserMapper;
import com.mall.dao.pojo.User;
import com.mall.service.api.UserService;
import com.mall.service.converter.UserConverter;
import com.mall.service.dto.UserDto;
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
    public UserDto getByUsernameAndPassword(String username, String password) {
        return UserConverter.CONVERTER.pojoToDto(userMapper.selectByUsernameAndPassword(username, password));
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public UserDto save(UserDto userDto) {
        synchronized (this) {
            if (subjectIsExist(userDto.getUsername()) > 0) {
                throw new BusinessException(SpringUtil.getMessage("username.exist"));
            }
            User user = UserConverter.CONVERTER.dtoToPojo(userDto);
            userMapper.save(user);
            return UserConverter.CONVERTER.pojoToDto(user);
        }
    }

    @Override
    public int subjectIsExist(String subject) {
        return userMapper.subjectIsExist(subject);
    }
}