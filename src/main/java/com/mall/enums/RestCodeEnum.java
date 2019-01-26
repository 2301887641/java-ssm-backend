package com.mall.enums;

import lombok.Getter;

/**
 * 状态码枚举
 *
 * @author suiguozhen on 19-1-17 下午10:02
 */
@Getter
public enum RestCodeEnum {
    /*操作成功*/
    SUCCESS(200, "操作成功"),
    NOT_LOGIN(401, "未登录或登录已失效"),
    /**
     * 自定义异常 显示给前台
     */
    EXCEPTION(500, "请求错误"),
    ERROR(600, "网络繁忙，请稍后重试");
    private Integer ordinal;
    private String label;

    RestCodeEnum(Integer ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
     }
    }