package com.mall.service.api;

import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeEnum;

/**
 * @author suiguozhen on 19-1-27 下午8:13
 */
public interface VerifyCodeRecordService {
    /**
     * 获取指定手机号和类型的最后一条记录
     * @param phone 手机号
     * @param verifyCodeEnum 类型
     * @return VerifyCodeRecordDto
     */
    VerifyCodeRecordDto getTodayLastRecord(String phone,VerifyCodeEnum verifyCodeEnum);

    /**
     * 添加记录
     * @param verifyCodeRecordDto verifyCodeRecordDto
     * @return int
     */
    int save(VerifyCodeRecordDto verifyCodeRecordDto);
}
