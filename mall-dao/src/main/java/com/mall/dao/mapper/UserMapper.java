package com.mall.dao.mapper;

import com.mall.core.foundation.BaseMapper;
import com.mall.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据用户主体数据进行查找
     * @param username 用户主体数据
     * @return int
     */
    int subjectIsExist(String username);

    /**
     * 用户登录
     * @param username 姓名
     * @return user
     */
    User selectByUsername(String username);
}
