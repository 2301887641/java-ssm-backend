package com.mall.core.exception;


import com.mall.core.enums.BaseEnum;
import com.mall.core.enums.RestCodeEnum;

/**
 * 业务层异常直接反馈给前台用户
 *
 * @author suiguozhen on 18/07/27
 */
public class BusinessException extends LogicException {

    /**
     * 自定义信息构造
     * @param message 错误信息
     */
    public BusinessException(String message){
        super(RestCodeEnum.ERROR.getOrdinal(),message);
    }

    /**
     * 带有状态码和错误消息的构造函数
     * @param enums  异常枚举
     * @param message  错误信息
     */
    public BusinessException(BaseEnum enums, String message) {
        super(enums.getOrdinal(), message);
    }
}