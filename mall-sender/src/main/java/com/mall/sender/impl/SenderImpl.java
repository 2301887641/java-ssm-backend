package com.mall.sender.impl;

import com.mall.sender.api.Sender;
import com.mall.sender.enums.VerifyCodeTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 短信发送管理器接口实现
 *
 * @author suiguozhen on 19/01/24 19:31
 */
@Service
@Slf4j
public class SenderImpl implements Sender {
    private static final Logger logger = LoggerFactory.getLogger(SenderImpl.class);

    @Override
    public void sendStrategy(VerifyCodeTypeEnum verifyCodeTypeEnum, String target, String code, String template) {
        if(VerifyCodeTypeEnum.SMS.equals(verifyCodeTypeEnum)){
            sendSms(target,code,template);
        }
    }

    @Override
    public void sendSms(String phone,String code, String template) {
        logger.info("send sms, phone: {}, code:{}, template: {}",phone,code,template);
    }
}
