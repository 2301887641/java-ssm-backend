package com.mall.core.exception;


import com.mall.core.foundation.BaseEnum;
import com.mall.core.foundation.RestCodeEnum;
import com.mall.core.foundation.BaseException;

/**
 * log异常 后台拦截后直接呈现在控制台和日志中
 * @author suiguozhen on 18/10/23
 */
public class ConsoleLogException extends BaseException {

    /**
     * 有参构造
     * @param message 异常信息
     */
    public ConsoleLogException(String message){
        super(RestCodeEnum.ERROR.getOrdinal(),message);
    }

    /**
     * 自定义信息构造
     * @param enums  异常枚举
     * @param message  错误信息
     */
    public ConsoleLogException(BaseEnum enums, String message){
        super(enums.getOrdinal(),message);
    }
}
