package com.mall.service.impl;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.common.SpringUtil;
import com.mall.dto.VerifyCodeDto;
import com.mall.dto.VerifyCodeRecordDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.service.api.VerifyCodeRecordService;
import com.mall.service.api.VerifyCodeService;
import com.mall.thirdparty.verifycode.api.SmsSender;
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

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeType) {
        //查询发送总数
        VerifyCodeRecordDto verifyCodeRecordDto = verifyCodeRecordService.getTodayLastRecord(phone, verifyCodeType);
        if (Objects.nonNull(verifyCodeRecordDto)) {
            if (verifyCodeRecordDto.getCount() >= Integer.valueOf(SpringUtil.getPropertiesValue("verifyCode.restrict.number"))) {
                return Result.failed(SpringUtil.getMessage("verifyCode.count.restrict"));
            }
//            validate(new Code(verifyCodeRecordDto.getCode(),verifyCodeRecordDto.)
        }
        //查询是否存在模板

//        if (Objects.isNull(verifyCodeTemplate)) {
//            logger.error(ConstantsMessage.Error.CODE_TEMPLATE_NOT_EXIST);
//            return Result.failed(SpringUtil.getMessage("exception.network.error"));
//        }
//        String code = RandomStringUtils.randomNumeric(codeLength);
//        smsSender.sendSms(phone, code,verifyCodeTemplate.getId());
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
}
