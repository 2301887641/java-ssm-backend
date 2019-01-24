package com.mall.thirdparty.verifycode.api;

/**
 * 短信发送管理器接口
 * @author suiguozhen on 19/01/24 19:22
 */
public interface SmsSender {
    /**
     * 根据手机号和模板id进行发送
     * @param phone  手机号
     * @param templateId  模板id
     */
    void sendSms(String phone,Integer templateId);
}
