package com.mall.dao.mapper;


import com.mall.dao.pojo.VerifyCodeRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author suiguozhen on 19-1-27 下午7:34
 */
@Mapper
public interface VerifyCodeRecordMapper {
    /**
     * 查询指定类型今天最后一条记录
     * @param verifyCodeRecord 实体
     * @return VerifyCodeRecordService
     */
    VerifyCodeRecord selectTodayLastRecord(VerifyCodeRecord verifyCodeRecord);

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
