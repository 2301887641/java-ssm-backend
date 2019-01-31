package com.mall.dto;

import com.mall.enums.VerifyCodeBusinessEnum;
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

    public static VerifyCodeRecordDto of( String code, String target,LocalDateTime sendTime, LocalDateTime expireTime, VerifyCodeBusinessEnum verifyCodeType) {
        VerifyCodeRecordDto verifyCodeRecordDto = new VerifyCodeRecordDto();
        verifyCodeRecordDto.setCode(code);
        verifyCodeRecordDto.setTarget(target);
        verifyCodeRecordDto.setSendTime(sendTime);
        verifyCodeRecordDto.setExpireTime(expireTime);
        verifyCodeRecordDto.setVerifyCodeType(verifyCodeType);
        return verifyCodeRecordDto;
    }
}
