package com.mall.dto;

import com.mall.enums.VerifyCodeEnum;
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
    private VerifyCodeEnum verifyCodeType;
    private String template;
    private String templateName;
}
