package com.mall.controller.portal;

import com.mall.context.util.ShiroUtil;
import com.mall.context.util.SpringUtil;
import com.mall.core.constant.ConstantsPool;
import com.mall.core.foundation.Result;
import com.mall.core.util.FrontUtil;
import com.mall.sender.api.VerifyCodeService;
import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.enums.VerifyCodeTypeEnum;
import com.mall.service.api.UserService;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


/**
 * 登录相关
 *
 * @author suiguozhen on 19/01/19 15:06
 */
@Controller
@Validated
public class LoginController {

    private static final String TEMPLATE_DIR = "login";
    private static final String TEMPLATE_NAME = "login";

    @Autowired
    private UserService userService;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @GetMapping("/login.jspx")
    public String toLogin() {
        return FrontUtil.getTemplatePath(TEMPLATE_DIR, TEMPLATE_NAME);
    }

    @PostMapping("/login.jspx")
    @ResponseBody
    public Result<Void> doLogin(HttpServletRequest request, @NotBlank(message = "{phone.required}") String username,
                                @NotBlank(message = "{password.required}") String password,
                                @NotBlank(message = "{verifyCode.required}") String captcha) {
        Subject subject = ShiroUtil.getSubject();
        try {
            VerifyCodeRecordDto verifyCodeRecordDto = (VerifyCodeRecordDto) request.getSession().getAttribute(VerifyCodeService.CAPTCHA_SESSION_NAME);
            Result<Void> validate = verifyCodeService.validate(VerifyCodeTypeEnum.CAPTCHA, verifyCodeRecordDto, captcha);
            if (!validate.isSuccess()) {
                return validate;
            }
            subject.login(new UsernamePasswordToken(username, password));
        } catch (UnknownAccountException | IncorrectCredentialsException e) {
            return Result.failed(SpringUtil.getMessage("validation.user.isNull"));
        }
        if(subject.isAuthenticated()){
            return Result.success();
        }
        return Result.failed(SpringUtil.getMessage("validation.user.isNull"));
    }

    @GetMapping("/logout.jspx")
    public Result<Void> logout() {
        Subject subject = ShiroUtil.getSubject();
        subject.logout();
        return Result.success();
    }
}
