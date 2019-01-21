package com.mall.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

/**
 * spring相关方法
 *
 * @author suiguozhen on 19/01/21 20:04
 */
@Component
public class SpringUtils implements ApplicationContextAware {
    private static MessageSource messageSource;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtils.applicationContext = applicationContext;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        SpringUtils.messageSource = messageSource;
    }

    public static String getMessage(String key, String... variables) {
        MessageSource messageSource = SpringUtils.applicationContext.getBean(MessageSource.class);
        return messageSource.getMessage(key, variables, LocaleContextHolder.getLocale());
    }
}
