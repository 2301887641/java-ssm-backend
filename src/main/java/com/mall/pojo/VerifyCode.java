package com.mall.pojo;

import com.mall.enums.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suiguozhen on 19/01/24 11:01
 */
@Getter
@Setter
public class VerifyCode extends BasePojo{
    private Integer id;
    private VerifyCodeEnum verifyCodeType;
    private String template;
    private String templateName;
}
