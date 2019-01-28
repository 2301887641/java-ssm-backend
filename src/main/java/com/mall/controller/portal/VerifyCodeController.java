package com.mall.controller.portal;

import com.mall.common.Result;
import com.mall.constant.ConstantsPool;
import com.mall.enums.VerifyCodeEnum;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * 验证码控制器
 * @author suiguozhen on 19/01/24 13:28
 */
@RestController
@Validated
public class VerifyCodeController {
    @PostMapping("/smsCode.do")
    public Result<Void> smsCode(@NotNull(message = "{validation.phone.required}")
                           @Pattern(message="{validation.phone.regexp}",
                           regexp = ConstantsPool.Regexp.PHONE_PATTERN)String phone,
                           @NotNull VerifyCodeEnum verifyCodeEnum){

        return null;
    }
}
