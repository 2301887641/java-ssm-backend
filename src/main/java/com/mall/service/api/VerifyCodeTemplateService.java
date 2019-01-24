package com.mall.service.api;

import com.mall.enums.VerifyCodeEnum;
import com.mall.pojo.VerifyCodeTemplate;

/**
 * 验证码模板
 * @author suiguozhen on 19/01/24 16:22
 */
public interface VerifyCodeTemplateService {
    /**
     * 公国验证码类型查找
     * @param verifyCodeEnum 验证码类型
     * @return VerifyCodeTemplate
     */
    VerifyCodeTemplate getByType(VerifyCodeEnum verifyCodeEnum);
}
