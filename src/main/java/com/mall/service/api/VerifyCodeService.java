package com.mall.service.api;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.dto.VerifyCodeDto;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeBusinessEnum;

/**
 * 验证码服务类
 * @author suiguozhen on 19/01/24 10:56
 */
public interface VerifyCodeService {

    /**
     * 发送短信验证码
     * @param phone 手机
     * @param verifyCodeBusinessEnum 验证码枚举
     * @return Result
     */
    Result<Void> sendSmsCode(String phone, VerifyCodeBusinessEnum verifyCodeBusinessEnum);

    /**
     * 发送邮箱验证码
     * @param email 邮箱
     * @param verifyCodeBusinessEnum 验证码枚举
     * @return Result
     */
    Result<Void> sendEmailCode(String email,VerifyCodeBusinessEnum verifyCodeBusinessEnum);

    /**
     * 校验验证码 图片验证码 短信验证码
     * @param code  放在session或数据库中的code实体
     * @param requestCode  前端请求携带的code
     * @return Result
     */
    Result<Void> validate(Code code,String requestCode);

    /**
     * 根据类型查询
     * @param verifyCodeType 类型
     * @return  VerifyCodeDto
     */
    VerifyCodeDto getByType(VerifyCodeBusinessEnum verifyCodeType);

    /**
     * 预检发送短信验证码
     * @param verifyCodeBusinessEnum 验证码业务类型
     * @param verifyCodeRecordDto 验证码记录dto
     * @return Result
     */
    Result<VerifyCodeDto> preCheckSend(VerifyCodeBusinessEnum verifyCodeBusinessEnum, VerifyCodeRecordDto verifyCodeRecordDto);
}
