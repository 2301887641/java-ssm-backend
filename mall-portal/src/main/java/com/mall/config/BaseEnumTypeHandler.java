package com.mall.config;

import com.mall.dao.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举持久化类型处理器
 *
 * @author suiguozhen on 19/01/29 16:14
 */
public class BaseEnumTypeHandler<E extends BaseEnum> extends BaseTypeHandler<E> {
    private Class<E> type;
    private E[] enums;

    public BaseEnumTypeHandler(Class<E> type) {
        this.type = type;
        this.enums = type.getEnumConstants();
    }

    /**
     * 获取枚举类
     * @param ordinal
     * @return
     */
    private E getEnum(Object ordinal) {
        for (E enumType : enums) {
            if (enumType.getOrdinal().equals(ordinal)) {
                return enumType;
            }
        }
        throw new IllegalArgumentException("未知的枚举类型：" + ordinal + ",请核对" + type.getSimpleName());
    }

    /**
     * 用于定义在Mybatis设置参数时该如何把Java类型的参数转换为对应的数据库类型
     * @param preparedStatement 执行的mybatis的statement
     * @param i   sql 参数索引位置
     * @param baseEnum  枚举类
     * @param jdbcType jdbc type
     * @throws SQLException 异常
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, BaseEnum baseEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, baseEnum.getOrdinal());
    }

    /**
     * 用于在Mybatis获取数据结果集时如何把数据库类型转换为对应的Java类型
     * @param resultSet 当前的结果集
     * @param columnName 当前的字段名称
     * @return 转换后的Java对象
     * @throws SQLException sql异常
     */
    @Override
    public E getNullableResult(ResultSet resultSet, String columnName) throws SQLException {
        return  getEnum(resultSet.getInt(columnName));
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        System.out.println(333);
        return null;
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        System.out.println(444);
        return null;
    }
}
