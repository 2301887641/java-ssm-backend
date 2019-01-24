package com.mall.service.impl;

import com.mall.dto.VerifyCodeDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.service.api.VerifyCodeService;
import org.springframework.stereotype.Service;

/**
 * @author suiguozhen on 19/01/24 10:56
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {
    @Override
    public VerifyCodeDto getByPhoneAndType(String phone, VerifyCodeEnum verifyCodeEnum) {
        return null;
    }
}
