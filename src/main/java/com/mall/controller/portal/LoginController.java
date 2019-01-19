package com.mall.controller.portal;

import com.mall.common.ConstantsPool;
import com.mall.common.Result;
import com.mall.pojo.User;
import com.mall.service.api.UserService;
import com.mall.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

/**
 * 登录相关
 * @author suiguozhen on 19/01/19 15:06
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login.do")
    @ResponseBody
    public Result doLogin(com.mall.vo.User user){
        User users = userService.login(user.getUsername(),user.getPassword());
        System.out.println(SecurityUtil.messageDigest("123456"));
        if(Objects.isNull(users)){
            return Result.failed(ConstantsPool.USER_NOT_FOUND);
        }
        return null;
    }
}
