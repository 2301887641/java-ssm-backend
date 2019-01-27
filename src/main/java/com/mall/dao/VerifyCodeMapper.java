package com.mall.dao;

import com.mall.enums.VerifyCodeEnum;
import com.mall.pojo.VerifyCode;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suiguozhen on 19-1-27 下午2:28
 */
@Mapper
public interface VerifyCodeMapper {
    VerifyCode selectByPhoneAndType(@Param("phone") String phone, @Param("type") VerifyCodeEnum verifyCodeEnum);
}
