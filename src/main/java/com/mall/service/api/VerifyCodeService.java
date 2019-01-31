package com.mall.service.api;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.dto.VerifyCodeDto;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeBusinessEnum;
import com.mall.enums.VerifyCodeTypeEnum;

/**
 * 验证码服务类
 * @author suiguozhen on 19/01/24 10:56
 */
public interface VerifyCodeService {

    /**
     * 发送短信或邮箱验证码
     * @param verifyCodeTypeEnum 类型 区分手机或邮箱
     * @param target 手机或邮箱
     * @param verifyCodeBusinessEnum 验证码枚举
     * @return Result
     */
    Result<String> sendCode(VerifyCodeTypeEnum verifyCodeTypeEnum,String target, VerifyCodeBusinessEnum verifyCodeBusinessEnum);

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
     * 预检发送验证码
     * @param verifyCodeBusinessEnum 验证码业务类型
     * @param verifyCodeRecordDto 验证码记录dto
     * @return Result
     */
    Result<VerifyCodeDto> preCheckSend(VerifyCodeBusinessEnum verifyCodeBusinessEnum, VerifyCodeRecordDto verifyCodeRecordDto);
}
