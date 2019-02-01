package com.mall.service.impl;

import com.mall.converter.VerifyCodeRecordConverter;
import com.mall.dao.VerifyCodeRecordMapper;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeBusinessEnum;
import com.mall.pojo.VerifyCodeRecord;
import com.mall.service.api.VerifyCodeRecordService;
import com.mall.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 验证码记录
 * @author suiguozhen on 19-1-27 下午8:13
 */
@Service
public class VerifyCodeRecordServiceImpl implements VerifyCodeRecordService {

    @Autowired
    private VerifyCodeRecordMapper verifyCodeRecordMapper;

    @Override
    public VerifyCodeRecordDto getTodayLastRecord(VerifyCodeRecordDto verifyCodeRecordDto) {
        verifyCodeRecordDto.setSendTime(DateTimeUtil.getTodayLocalDateTime());
        return VerifyCodeRecordConverter.CONVERTER.pojoToDto(verifyCodeRecordMapper.selectTodayLastRecord(verifyCodeRecordDto));
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void update(VerifyCodeRecordDto verifyCodeRecordDto) {
        verifyCodeRecordMapper.update(VerifyCodeRecordConverter.CONVERTER.dtoToPojo(verifyCodeRecordDto));
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public VerifyCodeRecordDto save(VerifyCodeRecordDto verifyCodeRecordDto) {
        VerifyCodeRecord verifyCodeRecord = VerifyCodeRecordConverter.CONVERTER.dtoToPojo(verifyCodeRecordDto);
        verifyCodeRecordMapper.save(verifyCodeRecord);
        return VerifyCodeRecordConverter.CONVERTER.pojoToDto(verifyCodeRecord);
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateForIsChecked(Integer id, Boolean isChecked) {
        verifyCodeRecordMapper.updateForIsChecked(id,isChecked);
    }
}
