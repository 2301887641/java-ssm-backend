package com.mall.manager.verifycode.impl;

import com.mall.common.Result;
import com.mall.enums.VerifyCodeEnum;
import com.mall.manager.verifycode.api.VerifyCodeManager;
import com.mall.service.api.VerifyCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 验证码服务实现
 * @author suiguozhen on 19/01/24 10:39
 */
@Service
public class VerifyCodeManagerImpl implements VerifyCodeManager {

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeEnum) {
        verifyCodeService.getByPhone
    }

    @Override
    public Result<Void> sendEmailCode(String email, VerifyCodeEnum verifyCodeEnum) {

    }
}
