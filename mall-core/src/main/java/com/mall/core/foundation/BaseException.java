package com.mall.core.foundation;

import lombok.Getter;
import lombok.Setter;

import java.text.MessageFormat;

/**
 * 运行时异常基类 分为:
 * ①业务异常
 * ②控制台异常
 *
 * @author suiguozhen on 18/07/27
 */
@Getter
@Setter
public class BaseException extends RuntimeException {
    /*** 状态码*/
    protected Integer code;

    /*** 错误消息*/
    protected String msg;

    /*** 带有状态码和错误消息的构造函数*/
    public BaseException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    /**
     * java如何让自定义异常不追踪堆栈信息
     * @return this
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }

    @Override
    public String toString() {
        return MessageFormat.format("{0}[{1}]",this.code,this.msg);
    }
}
