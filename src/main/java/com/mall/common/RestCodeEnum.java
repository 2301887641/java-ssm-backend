package com.mall.common;

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
    /**
     * 自定义异常 显示给前台
     */
    ERROR(500, "请求错误");
    private Integer ordinal;
    private String label;

    RestCodeEnum(Integer ordinal, String label) {
        this.ordinal = ordinal;
        this.label = label;
     }
    }