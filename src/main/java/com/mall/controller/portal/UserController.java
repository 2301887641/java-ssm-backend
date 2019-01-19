package com.mall.controller.portal;

import com.mall.common.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author suiguozhen on 19/01/19 13:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(){
        return null;
    }

    @PostMapping("/login.do")
    @ResponseBody
    public Result doLogin(){
        return null;
    }
}