package com.mall.service.api;

import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeBusinessEnum;

/**
 * @author suiguozhen on 19-1-27 下午8:13
 */
public interface VerifyCodeRecordService {
    /**
     * 获取指定手机号和类型的最后一条记录
     * @param phone 手机号
     * @param verifyCodeBusinessEnum 类型
     * @return VerifyCodeRecordDto
     */
    VerifyCodeRecordDto getTodayLastRecord(String phone,VerifyCodeBusinessEnum verifyCodeBusinessEnum);

    /**
     * 添加记录
     * @param verifyCodeRecordDto verifyCodeRecordDto
     * @return VerifyCodeRecordDto
     */
    VerifyCodeRecordDto save(VerifyCodeRecordDto verifyCodeRecordDto);

    /**
     * 修改记录
     * @param verifyCodeRecordDto verifyCodeRecordDto
     */
    void update(VerifyCodeRecordDto verifyCodeRecordDto);
}
