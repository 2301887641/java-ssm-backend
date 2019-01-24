package com.mall.service.api;

import com.mall.dto.VerifyCodeDto;
import com.mall.enums.VerifyCodeEnum;

/**
 * 验证码服务类
 * @author suiguozhen on 19/01/24 10:56
 */
public interface VerifyCodeService {
    /**
     * 根据手机号和短信业务类型查询
     * @param phone  手机
     * @param verifyCodeEnum 类型
     * @return VerifyCodeDto
     */
    VerifyCodeDto getByPhoneAndType(String phone, VerifyCodeEnum verifyCodeEnum);

}
