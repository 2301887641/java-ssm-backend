package com.mall.thirdparty.verifycode.api;

import com.mall.common.Result;
import com.mall.enums.VerifyCodeEnum;

/**
 * 验证码服务类
 * @author suiguozhen on 19/01/24 8:28
 */
public interface VerifyCodeSender {
    /**
     * 发送短信验证码
     * @param phone 手机
     * @param verifyCodeEnum 验证码枚举
     * @return Result
     */
    Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeEnum);

    /**
     * 发送邮箱验证码
     * @param email 邮箱
     * @param verifyCodeEnum 验证码枚举
     * @return Result
     */
    Result<Void> sendEmailCode(String email,VerifyCodeEnum verifyCodeEnum);
}
