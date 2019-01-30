package com.mall.dao;

import com.mall.enums.VerifyCodeBusinessEnum;
import com.mall.pojo.VerifyCodeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suiguozhen on 19-1-27 下午7:34
 */
@Mapper
public interface VerifyCodeRecordMapper {
    /**
     * 查询指定类型今天最后一条记录
     * @param verifyCodeBusinessEnum 类型
     * @param time  今天起始时间
     * @param phone 手机号
     * @return VerifyCodeRecordService
     */
    VerifyCodeRecord selectTodayLastRecord(@Param("phone")String phone, @Param("type") VerifyCodeBusinessEnum verifyCodeBusinessEnum, @Param("time") Long time);

    /**
     * 保存完整记录
     * @param verifyCodeRecord verifyCodeRecord
     * @return int
     */
    int save(VerifyCodeRecord verifyCodeRecord);
}
