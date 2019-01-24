package com.mall.manager.verifycode.impl;

import com.mall.common.Result;
import com.mall.dto.VerifyCodeDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.manager.verifycode.api.VerifyCodeManager;
import com.mall.service.api.VerifyCodeService;
import com.mall.util.SpringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 验证码服务实现
 * @author suiguozhen on 19/01/24 10:39
 */
@Service
public class VerifyCodeManagerImpl implements VerifyCodeManager {

    @Value("${verifyCode.expire.time}")
    private Integer expireTime;

    @Value("${verifyCode.restrict.number}")
    private Integer restrictNumber;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeEnum) {
        VerifyCodeDto verifyCodeDto = verifyCodeService.getByPhoneAndType(phone, verifyCodeEnum);
        if(Objects.nonNull(verifyCodeDto)){
            if(verifyCodeDto.getCount()>=restrictNumber){
                return Result.failed(SpringUtil.getMessage("verifyCode.sms.count.restrict"));
            }
        }



    }

    @Override
    public Result<Void> sendEmailCode(String email, VerifyCodeEnum verifyCodeEnum) {
        return null;
    }
}
