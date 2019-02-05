package com.mall.service.api;

import com.mall.service.dto.VerifyCodeRecordDto;
import com.mall.dao.enums.VerifyCodeBusinessEnum;

/**
 * @author suiguozhen on 19-1-27 下午8:13
 */
public interface VerifyCodeRecordService {
    /**
     * 获取指定手机号和类型的最后一条记录
     * @param verifyCodeRecordDto  实体
     * @return VerifyCodeRecordDto
     */
    VerifyCodeRecordDto getTodayLastRecord(VerifyCodeRecordDto verifyCodeRecordDto);

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

    /**
     * 更新检查
     * @param id  id字段
     * @param isChecked 是否已检查
     */
    void updateForIsChecked(Integer id,Boolean isChecked);
}
