package com.mall.config;

import com.mall.enums.BaseEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举持久化类型处理器
 * @author suiguozhen on 19/01/29 16:14
 */
public class EnumPersistenceTypeHandler<E extends Enum<E> & BaseEnum> extends BaseTypeHandler<E> {

    private Class<E> clazz;

    public EnumPersistenceTypeHandler(){

    }

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, E e, JdbcType jdbcType) throws SQLException {

    }

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        return null;
    }

    @Override
    public E getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return null;
    }

    @Override
    public E getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
