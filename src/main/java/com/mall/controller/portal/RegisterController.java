package com.mall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
public class RegisterController {

    @GetMapping("/register.do")
    public String toRegister(HttpServletRequest request){
        return "/front/index";
    }
}
