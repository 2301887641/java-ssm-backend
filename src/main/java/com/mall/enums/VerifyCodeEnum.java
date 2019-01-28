package com.mall.enums;

import lombok.Getter;

/**
 * 验证码业务枚举
 * @author suiguozhen on 19/01/24 8:52
 */
@Getter
public enum VerifyCodeEnum implements BaseEnum{
    /**
     * 用户注册
     */
    REGISTER(1,"用户注册");
    private Integer ordinal;
    private String label;

    VerifyCodeEnum(Integer ordinal, String label){
        this.ordinal=ordinal;
        this.label=label;
    }
}
