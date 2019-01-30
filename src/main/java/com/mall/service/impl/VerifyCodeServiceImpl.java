package com.mall.service.impl;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.common.SpringUtil;
import com.mall.constant.ConstantsPool;
import com.mall.converter.VerifyCodeConverter;
import com.mall.dao.VerifyCodeMapper;
import com.mall.dto.VerifyCodeDto;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.exception.BusinessException;
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
 * @author suiguozhen on 19/01/24 10:56
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Value("${verifyCode.send.length}")
    private Integer codeLength;

    @Autowired
    private VerifyCodeRecordService verifyCodeRecordService;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private VerifyCodeMapper verifyCodeMapper;

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeType) {
        VerifyCodeRecordDto verifyCodeRecordDto = verifyCodeRecordService.getTodayLastRecord(phone, verifyCodeType);
        if (Objects.nonNull(verifyCodeRecordDto)) {
            //查询发送总数
            if (verifyCodeRecordDto.getCount() >= Integer.parseInt(SpringUtil.getPropertiesValue("verifyCode.restrict.number"))) {
                return Result.failed(SpringUtil.getMessage("verifyCode.count.restrict"));
            }
            //验证是否过期

        }
        //查询是否存在模板
        VerifyCodeDto verifyCodeDto = getByType(verifyCodeType);
        if(Objects.isNull(verifyCodeDto)){
            throw new BusinessException(ConstantsPool.Exception.VERIFY_CODE_TEMPLATE_NOT_EXIST);
        }
        String code = RandomStringUtils.randomNumeric(codeLength);
        smsSender.sendSms(phone, code,verifyCodeDto.getTemplate());

        return Result.success();
    }

    @Override
    public Result<Void> sendEmailCode(String email, VerifyCodeEnum verifyCodeEnum) {
        return null;
    }

    @Override
    public Result<Void> validate(Code code, String requestCode) {
        if(Objects.isNull(code) || LocalDateTime.now().isAfter(code.getExpireTime())){
            return Result.failed(SpringUtil.getMessage("verifyCode.not.exist"));
        }
        if(!StringUtils.equals(code.getCode(),requestCode)){
            return Result.failed(SpringUtil.getMessage("verifyCode.not.match"));
        }
        return Result.success();
    }

    @Override
    public VerifyCodeDto getByType(VerifyCodeEnum verifyCodeType) {
        return VerifyCodeConverter.CONVERTER.pojoToDto(verifyCodeMapper.selectByType(verifyCodeType.getOrdinal()));
    }
}
