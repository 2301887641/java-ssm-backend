package com.mall.exception;

/**
 * 运行时异常基类 分为:
 * ①业务异常businessException:有错误可以直接展示给客户看的错误  500错误
 * ②控制台异常ConsoleLogException:后台数据或逻辑错误,只展示给前台看错误信息 不反馈给用户  400错误
 * @author suiguozhen on 18/07/27
 */
public  class LogicException extends RuntimeException {
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

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
