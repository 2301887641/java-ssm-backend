package com.mall.service.impl;

import com.mall.common.Code;
import com.mall.common.Result;
import com.mall.controller.util.SpringUtil;
import com.mall.dto.VerifyCodeDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.service.api.VerifyCodeRecordService;
import com.mall.service.api.VerifyCodeService;
import com.mall.thirdparty.verifycode.api.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author suiguozhen on 19/01/24 10:56
 */
@Service
public class VerifyCodeServiceImpl implements VerifyCodeService {

    @Value("${verifyCode.restrict.number}")
    private Integer restrictNumber;

    @Value("${verifyCode.send.length}")
    private Integer codeLength;

    @Autowired
    private VerifyCodeRecordService verifyCodeRecordService;

    @Autowired
    private SmsSender smsSender;

    @Override
    public VerifyCodeDto getByPhoneAndType(String phone, VerifyCodeEnum verifyCodeEnum) {
        return null;
    }

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeEnum) {
        //查询发送总数
        verifyCodeRecordService.getTodayLastRecord(phone,verifyCodeEnum);
        VerifyCodeDto verifyCodeDto = getByPhoneAndType(phone, verifyCodeEnum);
        if (Objects.nonNull(verifyCodeDto)) {
            if (verifyCodeDto.getCount() >= restrictNumber) {
                return Result.failed(SpringUtil.getMessage("verifyCode.count.restrict"));
            }
        }
        //查询是否存在模板
//        VerifyCodeTemplate verifyCodeTemplate = verifyCodeTemplateService.getByType(verifyCodeEnum);
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
        if(Objects.isNull(code)){
            return Result.failed(SpringUtil.getMessage("verifyCode.not.exist"));
        }


        return null;
    }
}
