package com.mall.sender.verifyCode.mapper;

import com.mall.sender.verifyCode.enums.VerifyCodeBusinessEnum;
import com.mall.sender.verifyCode.pojo.VerifyCode;
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
