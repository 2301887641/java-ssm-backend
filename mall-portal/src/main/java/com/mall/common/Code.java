package com.mall.common;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * @author suiguozhen on 19/01/28 16:01
 */
@Getter
@Setter
public class Code {
    private String code;
    /*** 过期时间 当前时间加上秒数*/
    private LocalDateTime expireTime;

    public Code(String code, Long time) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(time);
    }

    public Code(String code, LocalDateTime time) {
        this.code = code;
        this.expireTime = time;
    }
}
