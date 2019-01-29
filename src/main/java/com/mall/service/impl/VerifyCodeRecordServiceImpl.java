package com.mall.service.impl;

import com.mall.converter.VerifyCodeRecordConverter;
import com.mall.dao.VerifyCodeRecordMapper;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.service.api.VerifyCodeRecordService;
import com.mall.util.DateTimeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * 验证码记录
 * @author suiguozhen on 19-1-27 下午8:13
 */
@Service
public class VerifyCodeRecordServiceImpl implements VerifyCodeRecordService {

    @Autowired
    private VerifyCodeRecordMapper verifyCodeRecordMapper;

    @Override
    public VerifyCodeRecordDto getTodayLastRecord(String phone,VerifyCodeEnum verifyCodeEnum) {
        return VerifyCodeRecordConverter.CONVERTER.pojoTodto(verifyCodeRecordMapper.selectTodayLastRecord(phone,verifyCodeEnum,DateTimeUtil.getTodayStartTimestamp()));
    }

    @Override
    public int save(VerifyCodeRecordDto verifyCodeRecordDto) {
        return 0;
    }
}
