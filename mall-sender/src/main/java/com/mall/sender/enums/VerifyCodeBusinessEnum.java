package com.mall.sender.enums;

import com.mall.core.foundation.BaseEnum;
import lombok.Getter;

/**
 * 验证码业务枚举
 * @author suiguozhen on 19/01/24 8:52
 */
@Getter
public enum VerifyCodeBusinessEnum implements BaseEnum {
    /**
     * 用户注册
     */
    REGISTER(1,"用户注册");
    private Integer ordinal;
    private String label;

    VerifyCodeBusinessEnum(Integer ordinal, String label){
        this.ordinal=ordinal;
        this.label=label;
    }
}
