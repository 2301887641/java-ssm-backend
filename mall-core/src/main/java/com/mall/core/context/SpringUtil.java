package com.mall.core.context;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * spring相关方法
 *
 * @author suiguozhen on 19/01/21 20:04
 */
@Component
public class SpringUtil extends SpringContextUtil implements EmbeddedValueResolverAware {

    private static MessageSource messageSource;

    private static StringValueResolver stringValueResolver;

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        SpringUtil.messageSource = messageSource;
    }

    /**
     * 获取国际化文件中的信息 实现动态传参
     *
     * @param key       国际化key
     * @param variables 动态传参
     * @return String
     */
    public static String getMessage(String key, String... variables) {
        return messageSource.getMessage(key, variables, LocaleContextHolder.getLocale());
    }

    public static String getPropertiesValue(String key) {
        return stringValueResolver.resolveStringValue("${"+key+"}");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver stringValueResolver) {
        SpringUtil.stringValueResolver = stringValueResolver;
    }
}
