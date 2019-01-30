package com.mall.config;

import com.mall.enums.BaseEnum;
import com.mall.enums.VerifyCodeEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 枚举持久化类型处理器
 *
 * @author suiguozhen on 19/01/29 16:14
 */
@MappedTypes({
        VerifyCodeEnum.class
})
public class EnumPersistenceTypeHandler<E extends BaseEnum> extends BaseTypeHandler<BaseEnum> {

    private Class<E> clazz;

//    public EnumPersistenceTypeHandler(Class<E> clazz) {
//        this.clazz = clazz;
//        String canonicalName = clazz.getCanonicalName();
//        System.out.println(111);
//    }

    /**
     * 使用枚举查询数据库时 可以直接转换为枚举的ordinal
     * VerifyCodeRecordDto getTodayLastRecord(String phone,VerifyCodeEnum verifyCodeEnum)
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

    @Override
    public E getNullableResult(ResultSet resultSet, String s) throws SQLException {
        System.out.println(222);
        return null;
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
