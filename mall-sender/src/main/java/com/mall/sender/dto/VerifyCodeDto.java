package com.mall.sender.dto;

import com.mall.core.foundation.BaseDto;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * 验证码
 * @author suiguozhen on 19/01/24 11:00
 */
@Getter
@Setter
public class VerifyCodeDto extends BaseDto {
    private Integer id;
    private VerifyCodeBusinessEnum verifyCodeType;
    private String template;
    private String templateName;
}
