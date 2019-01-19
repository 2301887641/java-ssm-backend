package com.mall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author suiguozhen on 19/01/19 13:08
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/login")
    public String login(){

    }
}
