package com.mall.service.dto;

import com.mall.dao.enums.VerifyCodeBusinessEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 验证码记录
 * @author suiguozhen on 19-1-27 下午7:35
 */
@Getter
@Setter
public class VerifyCodeRecordDto extends BaseDto{
    private Integer id;
    private Integer count;
    private String code;
    private String target;
    private LocalDateTime sendTime;
    private LocalDateTime expireTime;
    private VerifyCodeBusinessEnum verifyCodeType;
    private Boolean isChecked;

    /**
     * 第一次发送短信或邮箱保存
     * @param code 验证码
     * @param target  目标
     * @param sendTime  发送时间
     * @param expireTime  过期时间
     * @param verifyCodeType 验证码类型
     * @return VerifyCodeRecordDto
     */
    public static VerifyCodeRecordDto of( String code, String target,LocalDateTime sendTime, LocalDateTime expireTime, VerifyCodeBusinessEnum verifyCodeType) {
        VerifyCodeRecordDto verifyCodeRecordDto = new VerifyCodeRecordDto();
        verifyCodeRecordDto.setCode(code);
        verifyCodeRecordDto.setTarget(target);
        verifyCodeRecordDto.setSendTime(sendTime);
        verifyCodeRecordDto.setExpireTime(expireTime);
        verifyCodeRecordDto.setVerifyCodeType(verifyCodeType);
        return verifyCodeRecordDto;
    }

    /**
     * 再次发送短信或邮箱
     * @param code 验证码
     * @param expireTime 过期时间
     * @return VerifyCodeRecordDto
     */
    public static VerifyCodeRecordDto of(String code,LocalDateTime expireTime){
        VerifyCodeRecordDto verifyCodeRecordDto = new VerifyCodeRecordDto();
        verifyCodeRecordDto.setCode(code);
        verifyCodeRecordDto.setExpireTime(expireTime);
        return verifyCodeRecordDto;
    }

    /**
     * 获取指定目标今天指定类型的记录
     * @param target 目标对象
     * @param verifyCodeBusinessEnum 类型
     * @return VerifyCodeRecordDto
     */
    public static VerifyCodeRecordDto of(String target,VerifyCodeBusinessEnum verifyCodeBusinessEnum){
        VerifyCodeRecordDto verifyCodeRecordDto = new VerifyCodeRecordDto();
        verifyCodeRecordDto.setTarget(target);
        verifyCodeRecordDto.setVerifyCodeType(verifyCodeBusinessEnum);
        return verifyCodeRecordDto;
    }
}
