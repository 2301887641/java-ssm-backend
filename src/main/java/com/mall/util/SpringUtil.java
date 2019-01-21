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
public class SpringUtil implements ApplicationContextAware {

    private static MessageSource messageSource;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringUtil.applicationContext = applicationContext;
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        SpringUtil.messageSource = messageSource;
    }

    /**
     * 获取国际化文件中的信息 实现动态传参
     * @param key  国际化key
     * @param variables 动态传参
     * @return  String
     */
    public static String getMessage(String key, String... variables) {
        return messageSource.getMessage(key,variables, LocaleContextHolder.getLocale());
    }
}
