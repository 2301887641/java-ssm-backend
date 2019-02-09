package com.mall.dao.mapper;


import com.mall.core.foundation.BaseMapper;
import com.mall.dao.pojo.VerifyCodeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suiguozhen on 19-1-27 下午7:34
 */
@Mapper
public interface VerifyCodeRecordMapper extends BaseMapper<VerifyCodeRecord> {
    /**
     * 查询指定类型今天最后一条记录
     * @param verifyCodeRecord 实体
     * @return VerifyCodeRecordService
     */
    VerifyCodeRecord selectTodayLastRecord(VerifyCodeRecord verifyCodeRecord);

    /**
     * 更新已检查
     * @param id    id定位
     * @param isChecked 布尔值
     */
    void updateForIsChecked(@Param("id")Integer id,@Param("isChecked")Boolean isChecked);
}
