package com.mall.sender.impl;

import com.mall.core.util.LocalDateTimeUtil;
import com.mall.sender.api.VerifyCodeRecordService;
import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.pojo.VerifyCodeRecord;
import com.mall.sender.converter.VerifyCodeRecordConverter;
import com.mall.sender.mapper.VerifyCodeRecordMapper;
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
        verifyCodeRecordDto.setSendTime(LocalDateTimeUtil.getTodayLocalDateTime());
        return VerifyCodeRecordConverter.CONVERTER.pojoToDto(verifyCodeRecordMapper.selectTodayLastRecord(VerifyCodeRecordConverter.CONVERTER.dtoToPojo(verifyCodeRecordDto)));
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
        verifyCodeRecordDto.setId(verifyCodeRecord.getId());
        return verifyCodeRecordDto;
    }

    @Transactional(rollbackFor = {Exception.class})
    @Override
    public void updateForIsChecked(Integer id, Boolean isChecked) {
        verifyCodeRecordMapper.updateForIsChecked(id,isChecked);
    }
}
