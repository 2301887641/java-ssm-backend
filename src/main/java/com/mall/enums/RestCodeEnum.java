package com.mall.enums;

import lombok.Getter;

/**
 * 状态码枚举
 *
 * @author suiguozhen on 19-1-17 下午10:02
 */
@Getter
public enum RestCodeEnum implements BaseEnum {
    /***操作成功*/
    SUCCESS(200, "操作成功"),
    /*** 登陆失效*/
    NOT_LOGIN(401, "未登录或登录已失效"),
    /*** 未知错误*/
    ERROR(500, "网络繁忙，请稍后重试");
    private Integer ordinal;
    private String label;

    RestCodeEnum(Integer ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
    }
}