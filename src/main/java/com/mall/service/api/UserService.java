package com.mall.service.api;

import com.mall.common.Result;

/**
 * 用户
 * @author suiguozhen on 19/01/19 13:08
 */
public interface UserService {
    /**
     * 登录接口
     * @param username
     * @param password
     * @return
     */
    Result login(String username,String password);
}
