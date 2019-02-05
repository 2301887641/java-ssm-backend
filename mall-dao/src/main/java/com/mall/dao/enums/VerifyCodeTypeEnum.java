package com.mall.dao.enums;

import lombok.Getter;

/**
 * 验证码类型枚举
 *
 * @author suiguozhen on 19/01/30 14:29
 */
@Getter
public enum VerifyCodeTypeEnum implements BaseEnum {
    /*** 验证码类型*/
    SMS(1, "短信"),
    EMAIL(2, "邮箱"),
    CAPTCHA(3,"图片");

    private Integer ordinal;
    private String label;

    VerifyCodeTypeEnum(Integer ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
    }
}
