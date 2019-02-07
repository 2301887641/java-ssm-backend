package com.mall.controller.portal;

import com.mall.core.annotation.DoValid;
import com.mall.core.constant.ConstantsPool;
import com.mall.core.foundation.Result;
import com.mall.core.util.FrontUtil;
import com.mall.group.userDto.ValidationUserDto;
import com.mall.service.api.UserService;
import com.mall.service.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 登录相关
 *
 * @author suiguozhen on 19/01/19 15:06
 */
@Controller
public class LoginController {

    private static final String TEMPLATE_DIR = "login";
    private static final String TEMPLATE_NAME = "login";

    @Autowired
    private UserService userService;

    @GetMapping("/login.html")
    public String toLogin() {
        return FrontUtil.getTemplatePath(TEMPLATE_DIR,TEMPLATE_NAME);
    }

    @PostMapping("/login.do")
    @DoValid
    public Result<Void> doLogin(HttpSession session, @Validated({ValidationUserDto.ValidationFrontUserLogin.class}) UserDto userDto, BindingResult result) {
//        UserDto user = userService.getByUsernameAndPassword(userDto.getUsername(),SecurityUtil.messageDigest(userDto.getPassword()));
//        if(Objects.isNull(user)){
//            return Result.failed(SpringUtil.getMessage("validation.user.isNull"));
//        }
//        session.setAttribute(ConstantsPool.Session.USER_SESSION_NAME,user);
        return Result.success();
    }

    @GetMapping("/logout.do")
    public Result<Void> logout(HttpSession session) {
        session.removeAttribute(ConstantsPool.Session.USER_SESSION_NAME);
        return Result.success();
    }
}
