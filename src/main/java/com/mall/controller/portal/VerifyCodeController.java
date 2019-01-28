package com.mall.controller.portal;

import com.mall.common.Result;
import com.mall.constant.ConstantsPool;
import com.mall.enums.VerifyCodeEnum;
import com.mall.service.api.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 验证码控制器
 * @author suiguozhen on 19/01/24 13:28
 */
@RestController
@Validated
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 发送短信验证码
     * @param phone  手机
     * @param verifyCodeEnum 类型
     * @param captcha 验证码 注册时需要
     * @return Result
     */
    @PostMapping("/smsCode.do")
    public Result<Void> smsCode(@NotNull(message = "{validation.phone.required}")
                                @Pattern(message="{validation.phone.regexp}",
                                regexp = ConstantsPool.Regexp.PHONE_PATTERN)String phone,
                                @NotNull(message = "{exception.network.error}") VerifyCodeEnum verifyCodeEnum,
                                String captcha,
                                HttpSession session){
        if(VerifyCodeEnum.REGISTER.getOrdinal().equals(verifyCodeEnum.getOrdinal())){
            String cacheCaptcha = (String)session.getAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME);
            if()
        }
        return verifyCodeService.sendSmsCode(phone,verifyCodeEnum);
    }
}
