package com.mall.controller.portal;

import com.mall.core.constant.ConstantsPool;
import com.mall.core.foundation.Result;
import com.mall.core.util.FrontUtil;
import com.mall.dao.enums.VerifyCodeTypeEnum;
import com.mall.manager.util.ShiroUtil;
import com.mall.service.api.UserService;
import com.mall.service.api.VerifyCodeService;
import com.mall.service.dto.VerifyCodeRecordDto;
import org.apache.shiro.authc.AuthenticationException;
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
import javax.servlet.http.HttpSession;


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
        return FrontUtil.getTemplatePath(TEMPLATE_DIR,TEMPLATE_NAME);
    }

    @PostMapping("/login.jspx")
    @ResponseBody
    public Result<Void> doLogin(HttpServletRequest request,@NotBlank(message = "{phone.required}") String username,
                                @NotBlank(message = "{password.required}") String password,
                                @NotBlank(message = "{verifyCode.required}") String captcha) {
        try {
            VerifyCodeRecordDto verifyCodeRecordDto = (VerifyCodeRecordDto) request.getSession().getAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME);
            Result<Void> validate = verifyCodeService.validate(VerifyCodeTypeEnum.CAPTCHA, verifyCodeRecordDto, captcha);
            if(!validate.isSuccess()){
                return validate;
            }
            Subject subject = ShiroUtil.getSubject();
            subject.login(new UsernamePasswordToken(username, password));
        } catch (AuthenticationException e) {
            e.fillInStackTrace();
        }
        return Result.success();
    }

    @GetMapping("/logout.do")
    public Result<Void> logout(HttpSession session) {
        session.removeAttribute(ConstantsPool.Session.USER_SESSION_NAME);
        return Result.success();
    }
}
