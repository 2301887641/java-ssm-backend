package com.mall.exception;


import com.mall.enums.BaseEnum;

/**
 * log异常 后台拦截后直接呈现在控制台和日志中
 * @author suiguozhen on 18/10/23
 */
public class ConsoleLogException extends LogicException{

    /**
     * 带有状态码和错误消息的构造函数
     *
     * @param code
     * @param msg
     */
    public ConsoleLogException(Integer code, String msg) {
        super(code, msg);
    }

    /**
     * 有参构造
     * @param enums
     */
    public ConsoleLogException(BaseEnum enums){
        super(enums.getOrdinal(),enums.getLabel());
    }

    /**
     * 自定义信息构造
     * @param enums
     * @param message
     */
    public ConsoleLogException(BaseEnum enums, String message){
        super(enums.getOrdinal(),message);
    }
}
