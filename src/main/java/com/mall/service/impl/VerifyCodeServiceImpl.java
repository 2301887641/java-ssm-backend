package com.mall.service.impl;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.common.SpringUtil;
import com.mall.constant.ConstantsPool;
import com.mall.converter.VerifyCodeConverter;
import com.mall.dao.VerifyCodeMapper;
import com.mall.dto.VerifyCodeDto;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeBusinessEnum;
import com.mall.enums.VerifyCodeTypeEnum;
import com.mall.exception.BusinessException;
import com.mall.pojo.VerifyCode;
import com.mall.service.api.VerifyCodeRecordService;
import com.mall.service.api.VerifyCodeService;
import com.mall.thirdparty.verifycode.api.SmsSender;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 验证码
 *
 * @author suiguozhen on 19/01/24 10:56
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Value("${verifyCode.expire.time}")
    private Long verifyCodeExpireTime;

    @Value("${verifyCode.send.length}")
    private int verifyCodeLength;

    @Value("${verifyCode.restrict.number}")
    private Integer verifyCodeRestrictNumber;

    @Autowired
    private VerifyCodeRecordService verifyCodeRecordService;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeBusinessEnum verifyCodeBusinessEnum) {
        VerifyCodeRecordDto verifyCodeRecordDto = verifyCodeRecordService.getTodayLastRecord(phone, verifyCodeBusinessEnum);
        Result<VerifyCodeDto> result = preCheckSend(phone, verifyCodeBusinessEnum,verifyCodeRecordDto);
        if (!result.isSuccess()) {
            return Result.failed(result.getRestInfo());
        }
        String code = RandomStringUtils.randomNumeric(verifyCodeLength);
        smsSender.sendSms(phone, code, result.getData().getTemplate());
        if(Objects.isNull(verifyCodeRecordDto)){
            LocalDateTime now = LocalDateTime.now();
            //添加记录
            int save = verifyCodeRecordService.save(VerifyCodeRecordDto.of(code, phone, now, now.plusSeconds(verifyCodeExpireTime), verifyCodeBusinessEnum));
            return Result.success();
        }
        return Result.success();

    }

    @Override
    public Result<Void> sendEmailCode(String email, VerifyCodeBusinessEnum verifyCodeBusinessEnum) {
        return null;
    }

    @Override
    public Result<Void> validate(Code code, String requestCode) {
        if (Objects.isNull(code) || LocalDateTime.now().isAfter(code.getExpireTime())) {
            return Result.failed(SpringUtil.getMessage("verifyCode.not.exist"));
        }
        if (!StringUtils.equals(code.getCode(), requestCode)) {
            return Result.failed(SpringUtil.getMessage("verifyCode.not.match"));
        }
        return Result.success();
    }

    @Override
    public VerifyCodeDto getByType(VerifyCodeBusinessEnum verifyCodeBusinessEnum) {
        return VerifyCodeConverter.CONVERTER.pojoToDto(verifyCodeMapper.selectByType(verifyCodeBusinessEnum));
    }

    @Override
    public Result<VerifyCodeDto> preCheckSend(String phone, VerifyCodeBusinessEnum verifyCodeBusinessEnum, VerifyCodeRecordDto verifyCodeRecordDto) {
        if (Objects.nonNull(verifyCodeRecordDto)) {
            //查询发送总数
            if (verifyCodeRecordDto.getCount() >= verifyCodeRestrictNumber) {
                return Result.failed(SpringUtil.getMessage("verifyCode.count.restrict"));
            }
            //验证是否过期
            if (LocalDateTime.now().isAfter(verifyCodeRecordDto.getExpireTime())) {
                return Result.failed(SpringUtil.getMessage("verifyCode.not.exist"));
            }
        }
        //查询是否存在模板
        VerifyCodeDto verifyCodeDto = getByType(verifyCodeBusinessEnum);
        if (Objects.isNull(verifyCodeDto)) {
            throw new BusinessException(ConstantsPool.Exception.VERIFY_CODE_TEMPLATE_NOT_EXIST);
        }
        return Result.success(verifyCodeDto);
    }
}
