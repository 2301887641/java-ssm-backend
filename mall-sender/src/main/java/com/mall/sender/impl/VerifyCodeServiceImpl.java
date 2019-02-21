package com.mall.sender.impl;

import com.mall.context.util.ShiroUtil;
import com.mall.context.util.SpringUtil;
import com.mall.core.constant.ConstantsPool;
import com.mall.core.exception.NetworkException;
import com.mall.core.foundation.Result;
import com.mall.sender.api.Sender;
import com.mall.sender.api.VerifyCodeRecordService;
import com.mall.sender.api.VerifyCodeService;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import com.mall.sender.enums.VerifyCodeTypeEnum;
import com.mall.sender.converter.VerifyCodeConverter;
import com.mall.sender.dto.VerifyCodeDto;
import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.mapper.VerifyCodeMapper;
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
    private Sender sender;

    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    @Override
    public Result<String> sendCode(VerifyCodeTypeEnum verifyCodeTypeEnum, String target, VerifyCodeBusinessEnum verifyCodeBusinessEnum) {
        VerifyCodeRecordDto verifyCodeRecordDto = verifyCodeRecordService.getTodayLastRecord(VerifyCodeRecordDto.of(target,verifyCodeBusinessEnum));
        Result<VerifyCodeDto> result = preCheckSend(verifyCodeBusinessEnum,verifyCodeRecordDto);
        if (!result.isSuccess()) {
            return Result.failed(result.getRestInfo());
        }
        String code = RandomStringUtils.randomNumeric(verifyCodeLength);
        sender.sendStrategy(verifyCodeTypeEnum,target, code, result.getData().getTemplate());
        LocalDateTime now = LocalDateTime.now();
        if(Objects.isNull(verifyCodeRecordDto)){
            verifyCodeRecordService.save(VerifyCodeRecordDto.of(code, target, now, now.plusSeconds(verifyCodeExpireTime), verifyCodeBusinessEnum));
            return Result.success(code);
        }
        verifyCodeRecordDto.setSendTime(now);
        verifyCodeRecordDto.setExpireTime(now.plusSeconds(verifyCodeExpireTime));
        verifyCodeRecordDto.setCode(code);
        verifyCodeRecordDto.setCount(verifyCodeRecordDto.getCount()+1);
        verifyCodeRecordService.update(verifyCodeRecordDto);
        return Result.success(code);
    }

    @Override
    public Result<Void> validate(VerifyCodeTypeEnum verifyCodeTypeEnum,VerifyCodeRecordDto verifyCodeRecordDto, String requestCode) {
        if(VerifyCodeTypeEnum.CAPTCHA.equals(verifyCodeTypeEnum)){
            ShiroUtil.getSession().removeAttribute(VerifyCodeService.CAPTCHA_SESSION_NAME);
        }
        if (Objects.isNull(verifyCodeRecordDto) || LocalDateTime.now().isAfter(verifyCodeRecordDto.getExpireTime())) {
            return Result.failed(SpringUtil.getMessage("verifyCode.expired"));
        }
        if (!StringUtils.equals(verifyCodeRecordDto.getCode(), requestCode)) {
            return Result.failed(SpringUtil.getMessage("verifyCode.mismatching"));
        }
        if(VerifyCodeTypeEnum.SMS.equals(verifyCodeTypeEnum)){
            if(verifyCodeRecordDto.getIsChecked()){
                return Result.failed(SpringUtil.getMessage("verifyCode.expired"));
            }
            verifyCodeRecordService.updateForIsChecked(verifyCodeRecordDto.getId(),true);
        }
        return Result.success();
    }

    @Override
    public VerifyCodeDto getByType(VerifyCodeBusinessEnum verifyCodeBusinessEnum) {
        return VerifyCodeConverter.CONVERTER.pojoToDto(verifyCodeMapper.selectByType(verifyCodeBusinessEnum));
    }

    @Override
    public Result<VerifyCodeDto> preCheckSend(VerifyCodeBusinessEnum verifyCodeBusinessEnum, VerifyCodeRecordDto verifyCodeRecordDto) {
        if (Objects.nonNull(verifyCodeRecordDto)) {
            //查询发送总数
            if (verifyCodeRecordDto.getCount() >= verifyCodeRestrictNumber) {
                return Result.failed(SpringUtil.getMessage("verifyCode.restrict"));
            }
            //修复 是否已检查
            if(verifyCodeRecordDto.getIsChecked()){
                verifyCodeRecordService.updateForIsChecked(verifyCodeRecordDto.getId(),false);
            }
        }
        //查询是否存在模板
        VerifyCodeDto verifyCodeDto = getByType(verifyCodeBusinessEnum);
        if (Objects.isNull(verifyCodeDto)) {
            throw new NetworkException(ConstantsPool.Exception.VERIFY_CODE_TEMPLATE_NOT_EXIST);
        }
        return Result.success(verifyCodeDto);
    }
}
