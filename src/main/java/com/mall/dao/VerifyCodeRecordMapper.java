package com.mall.dao;

import com.mall.dto.VerifyCodeRecordDto;
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
     * @param verifyCodeRecordDto 实体
     * @return VerifyCodeRecordService
     */
    VerifyCodeRecord selectTodayLastRecord(VerifyCodeRecordDto verifyCodeRecordDto);

    /**
     * 保存完整记录
     * @param verifyCodeRecord verifyCodeRecord
     * @return int
     */
    int save(VerifyCodeRecord verifyCodeRecord);

    /**
     * 修改记录
     * @param verifyCodeRecord verifyCodeRecord
     */
    void update(VerifyCodeRecord verifyCodeRecord);

    /**
     * 更新已检查
     * @param id    id定位
     * @param isChecked 布尔值
     */
    void updateForIsChecked(@Param("id")Integer id,@Param("isChecked")Boolean isChecked);
}
