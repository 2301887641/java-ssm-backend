package com.mall.controller.portal;

import com.mall.annotation.DoValidParam;
import com.mall.common.ConstantsPool;
import com.mall.common.Result;
import com.mall.dto.UserDto;
import com.mall.group.userDto.ValidationUserDto;
import com.mall.service.api.UserService;
import com.mall.util.SecurityUtil;
import com.mall.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * 登录相关
 * @author suiguozhen on 19/01/19 15:06
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login.do")
    @DoValidParam
    public Result<String> doLogin(HttpSession session, @Validated({ValidationUserDto.ValidationFrontUserLogin.class}) UserDto userDto, BindingResult result){
        UserDto user = userService.login(userDto.getUsername(),SecurityUtil.messageDigest(userDto.getPassword()));
        if(Objects.isNull(user)){
            return Result.failed(SpringUtil.getMessage("validation.userDto.web.login.isNull"));
        }
        session.setAttribute(ConstantsPool.USER_SESSION_NAME,user);
        return Result.success();
    }

    @GetMapping("/logout.do")
    public Result<String> logout(HttpSession session){
        session.removeAttribute(ConstantsPool.USER_SESSION_NAME);
        return Result.success();
    }

    @PostMapping("/register.do")
    public Result register(@Validated({ValidationUserDto.ValidationFrontUserRegister.class}) UserDto userDto,BindingResult bindingResult){

    }

    @GetMapping("/register.do")
    public Result<String> verifyUser(@NotNull("") String subject, String type){
        switch(type){
            case ConstantsPool.Subject.SUBJECT_PHONE:
            case ConstantsPool.Subject.SUBJECT_EMAIL:
            case ConstantsPool.Subject.SUBJECT_USERNAME:
                UserDto user = userService.getBySubject(subject);
                if(Objects.isNull(user)){
                    return Result.failed(SpringUtil.getMessage("user.subject.web.register."+type));
                }
                return Result.success();
        }
        return Result.failed();
    }
}
