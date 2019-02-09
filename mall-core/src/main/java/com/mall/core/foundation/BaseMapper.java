package com.mall.core.foundation;

/**
 * 基类mapper 通用增删改查
 * @author suiguozhen on 19-2-9 上午8:48
 */
public interface BaseMapper<T> {
    /**
     * 增
     * @param t 泛型实体
     * @return 泛型
     */
    T save(T t);

    /**
     * 改
     * @param t 泛型
     */
    void update(T t);
}
