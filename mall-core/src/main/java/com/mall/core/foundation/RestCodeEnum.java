package com.mall.core.foundation;

import com.mall.core.foundation.BaseEnum;
import lombok.Getter;

/**
 * 状态码枚举
 *
 * @author suiguozhen on 19-1-17 下午10:02
 */
@Getter
public enum RestCodeEnum implements BaseEnum {
    /***操作成功*/
    SUCCESS(200),
    /*** 登陆失效*/
    NOT_LOGIN(401),
    /*** 未知错误*/
    ERROR(500);
    private Integer ordinal;

    RestCodeEnum(Integer ordinal) {
        this.ordinal = ordinal;
    }
}