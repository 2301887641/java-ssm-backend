package com.mall.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * 运行时异常基类 分为:
 * ①业务异常
 * ②控制台异常
 *
 * @author suiguozhen on 18/07/27
 */
@Getter
@Setter
public class LogicException extends RuntimeException {
    /**
     * 状态码
     */
    public Integer code;

    /**
     * 错误消息
     */
    public String msg;

    /**
     * 带有状态码和错误消息的构造函数
     */
    public LogicException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }
}
