package com.mall.dao.mapper;

import com.mall.dao.enums.VerifyCodeBusinessEnum;
import com.mall.dao.pojo.VerifyCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suiguozhen on 19-1-27 下午2:28
 */
@Mapper
public interface VerifyCodeMapper {
    /**
     * 根据验证码类型查找
     * @param verifyCodeType 验证码类型
     * @return VerifyCode
     */
    VerifyCode selectByType(VerifyCodeBusinessEnum verifyCodeType);
}
