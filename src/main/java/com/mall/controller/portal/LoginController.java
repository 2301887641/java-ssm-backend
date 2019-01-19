package com.mall.controller.portal;

import com.mall.common.Result;
import com.mall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author suiguozhen on 19/01/19 15:06
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @PostMapping("/login.do")
    @ResponseBody
    public Result doLogin(String username,String password){
        userService.login(username,password);
        return null;
    }
}
