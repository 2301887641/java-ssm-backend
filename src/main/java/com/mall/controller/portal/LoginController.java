package com.mall.controller.portal;

import com.mall.common.ConstantsPool;
import com.mall.common.Result;
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
import org.springframework.web.servlet.support.RequestContext;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Locale;
import java.util.Objects;

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
    public Result doLogin(HttpServletRequest request, @Valid com.mall.vo.User user, BindingResult result){
        if(result.hasErrors()) {
            FieldError fieldError = result.getFieldError();
            String field = fieldError.getField();
            String defaultMessage = fieldError.getDefaultMessage();
            System.out.println(field+":"+defaultMessage);
        }
        User users = userService.login(user.getUsername(),user.getPassword());
        System.out.println(SecurityUtil.messageDigest("123456"));
//        if(Objects.isNull(users)){
//            return Result.failed(ConstantsPool.USER_NOT_FOUND);
//        }
        String money = messageSource.getMessage("money", null, Locale.SIMPLIFIED_CHINESE);
        System.out.println(money);
        RequestContext requestContext = new RequestContext(request);
        System.out.println(requestContext.getMessage("money"));
        return null;
    }
}
