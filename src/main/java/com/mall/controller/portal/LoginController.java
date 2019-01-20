package com.mall.controller.portal;

import com.mall.common.Result;
import com.mall.dto.UserDto;
import com.mall.pojo.User;
import com.mall.service.api.UserService;
import com.mall.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * 登录相关
 * @author suiguozhen on 19/01/19 15:06
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageSource messageSource;

    @PostMapping("/login.do")
    @ResponseBody
    public Result doLogin(HttpServletRequest request, @Valid UserDto userDto, BindingResult result){
        if(result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            System.out.println(field+":"+defaultMessage);
        }
        User users = userService.login(userDto.getUsername(), userDto.getPassword());
        System.out.println(SecurityUtil.messageDigest("123456"));
//        if(Objects.isNull(users)){
//            return Result.failed(ConstantsPool.USER_NOT_FOUND);
//        }
        return null;
    }
}
