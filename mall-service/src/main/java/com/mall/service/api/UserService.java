package com.mall.service.api;


import com.mall.service.dto.UserDto;

/**
 * 用户接口
 * @author suiguozhen on 19/01/19 13:08
 */
public interface UserService{
    /**
     * 登录接口
     * @param username 姓名
     * @return userDto
     */
    UserDto getByUsername(String username);

    /**
     * 用户注册
     * @param userDto userDto
     * @return int
     */
    UserDto save(UserDto userDto);

    /**
     * 根据用户主体数据查找
     * @param subject 用户主体数据
     * @return int
     */
    int subjectIsExist(String subject);
}
