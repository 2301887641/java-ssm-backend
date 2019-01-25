package com.mall.exception;


import com.mall.enums.BaseEnum;

/**
 * 业务层异常直接反馈给前台用户
 *
 * @author suiguozhen on 18/07/27
 */
public class BusinessException extends LogicException {

    /**
     * 有参构造
     * @param enums
     */
    public BusinessException(BaseEnum enums){
        super(enums.getOrdinal(),enums.getLabel());
    }

    /**
     * 自定义信息构造
     * @param enums
     * @param message
     */
    public BusinessException(BaseEnum enums, String message){
        super(enums.getOrdinal(),message);
    }

    /**
     * 带有状态码和错误消息的构造函数
     *
     * @param code
     * @param msg
     */
    public BusinessException(Integer code, String msg) {
        super(code, msg);
    }
}