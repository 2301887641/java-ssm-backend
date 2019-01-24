package com.mall.thirdparty.verifycode.impl;

import com.mall.thirdparty.verifycode.api.SmsSender;
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
public class SmsSenderImpl implements SmsSender {
    private static final Logger logger = LoggerFactory.getLogger(SmsSenderImpl.class);

    @Override
    public void sendSms(String phone, Integer templateId) {
        logger.info("send sms, phone: {}, templateId: {}",phone,templateId);
    }
}
