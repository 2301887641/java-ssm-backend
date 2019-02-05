package com.mall.controller.portal;

import com.mall.annotation.DoValid;
import com.mall.constant.ConstantsPool;
import com.mall.common.Result;
import com.mall.service.dto.UserDto;
import com.mall.group.userDto.ValidationUserDto;
import com.mall.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * 登录相关
 * @author suiguozhen on 19/01/19 15:06
 */
@RestController
public class LoginController {
    @Autowired
    private UserService userService;

    @PostMapping("/login.do")
    @DoValid
    public Result<Void> doLogin(HttpSession session, @Validated({ValidationUserDto.ValidationFrontUserLogin.class}) UserDto userDto, BindingResult result){
//        UserDto user = userService.getByUsernameAndPassword(userDto.getUsername(),SecurityUtil.messageDigest(userDto.getPassword()));
//        if(Objects.isNull(user)){
//            return Result.failed(SpringUtil.getMessage("validation.user.isNull"));
//        }
//        session.setAttribute(ConstantsPool.Session.USER_SESSION_NAME,user);
        return Result.success();
    }

    @GetMapping("/logout.do")
    public Result<Void> logout(HttpSession session){
        session.removeAttribute(ConstantsPool.Session.USER_SESSION_NAME);
        return Result.success();
    }

    @GetMapping("/register/{subject}/{type}.do")
    public Result<String> verifyUser(@PathVariable String subject,@PathVariable String type){

        return Result.failed();
    }
}
