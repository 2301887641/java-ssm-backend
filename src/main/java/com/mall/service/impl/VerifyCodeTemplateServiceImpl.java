package com.mall.service.impl;

import com.mall.enums.VerifyCodeEnum;
import com.mall.pojo.VerifyCodeTemplate;
import com.mall.service.api.VerifyCodeTemplateService;
import org.springframework.stereotype.Service;

/**
 * 验证码模板
 * @author suiguozhen on 19/01/24 16:22
 */
@Service
public class VerifyCodeTemplateServiceImpl implements VerifyCodeTemplateService {
    @Override
    public VerifyCodeTemplate getByType(VerifyCodeEnum verifyCodeEnum) {
        return null;
    }
}
