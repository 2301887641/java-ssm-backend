package com.mall.service.api;

import com.mall.common.Result;
import com.mall.pojo.User;

/**
 * 用户
 * @author suiguozhen on 19/01/19 13:08
 */
public interface UserService {
    /**
     * 登录接口
     * @param username
     * @param password
     * @return user
     */
    User login(String username, String password);
}
