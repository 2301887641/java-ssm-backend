package com.mall.service.api;

import com.mall.common.Code;
import com.mall.common.Result;
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

    /**
     * 校验验证码 图片验证码 短信验证码
     * @param code  放在session或数据库中的code实体
     * @param requestCode  前端请求携带的code
     * @return Result
     */
    Result<Void> validate(Code code,String requestCode);
}
