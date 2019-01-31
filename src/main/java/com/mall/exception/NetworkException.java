package com.mall.exception;

import com.mall.enums.BaseEnum;
import com.mall.enums.RestCodeEnum;

/**
 * 返回网络异常
 * @author suiguozhen on 19/01/31 15:34
 */
public class NetworkException extends LogicException{
    /**
     * 自定义信息构造
     * @param message 错误信息
     */
    public NetworkException(String message){
        super(RestCodeEnum.ERROR.getOrdinal(),message);
    }

    /**
     * 带有状态码和错误消息的构造函数
     * @param enums  异常枚举
     * @param message  错误信息
     */
    public NetworkException(BaseEnum enums, String message) {
        super(enums.getOrdinal(), message);
    }
}
