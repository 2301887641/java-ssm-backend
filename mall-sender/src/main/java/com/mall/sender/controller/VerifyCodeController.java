package com.mall.sender.controller;

import com.google.common.base.Strings;
import com.mall.context.util.ShiroUtil;
import com.mall.context.util.SpringUtil;
import com.mall.core.constant.ConstantsPool;
import com.mall.core.foundation.Result;
import com.mall.sender.api.VerifyCodeService;
import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import com.mall.sender.enums.VerifyCodeTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 验证码控制器
 *
 * @author suiguozhen on 19/01/24 13:28
 */
@RestController
@Validated
public class VerifyCodeController {

    @Autowired
    private VerifyCodeService verifyCodeService;

    /**
     * 发送短信验证码
     * @param phone          手机
     * @param verifyCodeType 类型
     * @param captcha        验证码 注册时需要
     * @return Result
     */
    @PostMapping("/smsCode.jspx")
    public Result<String> smsCode(@NotNull(message = "{phone.required}")
                                @Pattern(message = "{phone.incorrect.format}",
                                        regexp = ConstantsPool.Regexp.PHONE_PATTERN) String phone,
                                @NotNull(message = "{exception.network.error}") VerifyCodeBusinessEnum verifyCodeType,
                                String captcha) {
        if (VerifyCodeBusinessEnum.REGISTER.equals(verifyCodeType)) {
            if (Strings.isNullOrEmpty(captcha)) {
                return Result.failed(SpringUtil.getMessage("verifyCode.required"));
            }
            Result<Void> result = verifyCodeService.validate(VerifyCodeTypeEnum.CAPTCHA,(VerifyCodeRecordDto)(ShiroUtil.getSession().getAttribute(VerifyCodeService.CAPTCHA_SESSION_NAME)),captcha);
            if (!result.isSuccess()) {
                return Result.failed(result.getRestInfo());
            }
        }
        return verifyCodeService.sendCode(VerifyCodeTypeEnum.SMS, phone, verifyCodeType);
    }
}
