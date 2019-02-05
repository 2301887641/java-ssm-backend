package com.mall.core.enums;

/**
 * 枚举父类 统一实现接口
 * @author suiguozhen on 18/04/25
 */
public interface BaseEnum {

    /**
     * 获得标号 默认返回标号 rest请求时
     * @return integer
     */
    Integer getOrdinal();
}
