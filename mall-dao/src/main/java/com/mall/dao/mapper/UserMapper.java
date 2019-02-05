package com.mall.dao.mapper;

import com.mall.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Mapper
public interface UserMapper {
    /**
     * 根据用户主体数据进行查找
     * @param username 用户主体数据
     * @return int
     */
    int subjectIsExist(String username);

    /**
     * 用户登录
     * @param username 姓名
     * @param password 密码
     * @return user
     */
    User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    /**
     * 用户注册
     * @param user user
     */
    void save(User user);
}
