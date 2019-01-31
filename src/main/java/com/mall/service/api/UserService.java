package com.mall.service.api;


import com.mall.dto.UserDto;

/**
 * 用户接口
 * @author suiguozhen on 19/01/19 13:08
 */
public interface UserService{
    /**
     * 登录接口
     * @param username 姓名
     * @param password 密码
     * @return userDto
     */
    UserDto getByUsernameAndPassword(String username, String password);

    /**
     * 用户注册
     * @param userDto userDto
     * @return int
     */
    UserDto save(UserDto userDto);

    /**
     * 根据用户主体数据查找
     * @param subject 用户主体数据
     * @return userDto
     */
    UserDto getBySubject(String subject);
}
