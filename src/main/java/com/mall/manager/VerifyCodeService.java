package com.mall.manager;

import com.mall.enums.VerifyCodeEnum;

/**
 * 验证码服务类
 * @author suiguozhen on 19/01/24 8:28
 */
public interface VerifyCodeService {
    /**
     * 发送短信验证码
     * @param phone 手机
     * @param verifyCodeEnum 验证码枚举
     */
    void sendSmsCode(String phone,VerifyCodeEnum verifyCodeEnum);
}
