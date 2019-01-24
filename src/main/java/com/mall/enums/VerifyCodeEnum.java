package com.mall.enums;

import lombok.Getter;

/**
 * 业务类型
 * @author suiguozhen on 19/01/24 8:52
 */
@Getter
public enum VerifyCodeEnum {
    /**
     *
     */
    LOGIN(1,"用户登陆"),
    AUTHENTICATE(2,"用户认证");
    private Integer ordinal;
    private String label;

    VerifyCodeEnum(Integer ordinal, String label){
        this.ordinal=ordinal;
        this.label=label;
    }
}
