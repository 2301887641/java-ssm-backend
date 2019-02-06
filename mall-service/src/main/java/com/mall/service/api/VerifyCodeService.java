package com.mall.service.api;

import com.mall.core.foundation.Result;
import com.mall.dao.enums.VerifyCodeBusinessEnum;
import com.mall.dao.enums.VerifyCodeTypeEnum;
import com.mall.service.dto.VerifyCodeDto;
import com.mall.service.dto.VerifyCodeRecordDto;

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
     * @param verifyCodeTypeEnum 验证码类型
     * @param verifyCodeRecordDto  验证码实体
     * @param requestCode  前端请求携带的code
     * @return Result
     */
    Result<Void> validate(VerifyCodeTypeEnum verifyCodeTypeEnum, VerifyCodeRecordDto verifyCodeRecordDto, String requestCode);

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
