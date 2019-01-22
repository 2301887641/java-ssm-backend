package com.mall.controller.portal;

import com.mall.annotation.DoValidParam;
import com.mall.common.Result;
import com.mall.dto.UserDto;
import com.mall.group.userDto.ValidationUserDto;
import com.mall.service.api.UserService;
import com.mall.util.SecurityUtil;
import com.mall.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
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
    @DoValidParam
    public Result doLogin(HttpServletRequest request, @Validated({ValidationUserDto.ValidationUserLogin.class}) UserDto userDto, BindingResult result){
        UserDto user = userService.login(userDto.getUsername(), userDto.getPassword());
        System.out.println(SecurityUtil.messageDigest("123456"));
        if(Objects.isNull(user)){
            return Result.failed(SpringUtil.getMessage("validation.userDto.web.login.isNull"));
        }
        return null;
    }
}
