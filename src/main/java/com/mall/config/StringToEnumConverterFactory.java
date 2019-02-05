package com.mall.config;

import com.mall.dao.enums.BaseEnum;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;

/**
 * spring mvc 枚举转换工厂
 *
 * @author suiguozhen on 19/01/28 10:21
 */
public class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    @SuppressWarnings("unchecked")
    @Override
    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
        return new StringToEnumConverter(targetType);
    }

    /**
     * 字符串转枚举类
     * @param <T>
     */
    public class StringToEnumConverter<T extends BaseEnum> implements Converter<String, T> {
        private Class<T> clazz;

        @Override
        public T convert(String string) {
            for(T enumType:clazz.getEnumConstants()){
               if(enumType.getOrdinal().equals(Integer.valueOf(string))){
                    return enumType;
               }
            }
            return null;
        }

        public StringToEnumConverter(Class<T> enumType) {
            clazz = enumType;
        }
    }
}
