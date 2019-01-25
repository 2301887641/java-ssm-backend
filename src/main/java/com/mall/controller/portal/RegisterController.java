package com.mall.controller.portal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author suiguozhen on 19/01/25 16:10
 */
@Controller
public class RegisterController {

    @GetMapping("/register.do")
    public String toRegister(){
        return "register";
    }
}
