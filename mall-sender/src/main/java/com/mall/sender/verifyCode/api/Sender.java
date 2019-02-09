package com.mall.sender.verifyCode.api;

import com.mall.sender.verifyCode.enums.VerifyCodeTypeEnum;

/**
 * 短信发送管理器接口
 * @author suiguozhen on 19/01/24 19:22
 */
public interface Sender {
    /**
     * 根据手机号和模板id进行发送
     * @param phone  手机号
     * @param code   验证码
     * @param templateId  模板id
     */
    void sendSms(String phone,String code,String templateId);

    /**
     * 发送策略
     * @param verifyCodeTypeEnum  区别手机还是邮箱
     * @param target 手机还是邮箱
     * @param code  验证码
     * @param template  模板
     */
    void sendStrategy(VerifyCodeTypeEnum verifyCodeTypeEnum, String target, String code, String template);
}
