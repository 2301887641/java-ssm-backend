package com.mall.dao;

import com.mall.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Mapper
public interface UserMapper {
    /**
     * 根据username进行查找
     * @param username 姓名
     * @return User
     */
    User selectByUsername(String username);
}
