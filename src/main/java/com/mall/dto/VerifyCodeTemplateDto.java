package com.mall.dto;

import com.mall.enums.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suiguozhen on 19/01/24 16:24
 */
@Getter
@Setter
public class VerifyCodeTemplateDto extends BaseDto{
    private String content;
    private VerifyCodeEnum verifyCodeEnum;
}
