package com.mall.dao;

import com.mall.enums.VerifyCodeEnum;
import com.mall.pojo.VerifyCodeRecord;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author suiguozhen on 19-1-27 下午7:34
 */
@Mapper
public interface VerifyCodeRecordMapper {
    VerifyCodeRecord selectTodayLastRecord(VerifyCodeRecord verifyCodeRecord);
}
