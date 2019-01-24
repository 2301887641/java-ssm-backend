package com.mall.thirdparty.verifycode.impl;

import com.mall.common.Result;
import com.mall.dto.VerifyCodeDto;
import com.mall.enums.VerifyCodeEnum;
import com.mall.thirdparty.verifycode.api.SmsSender;
import com.mall.thirdparty.verifycode.api.VerifyCodeSender;
import com.mall.pojo.VerifyCodeTemplate;
import com.mall.service.api.VerifyCodeService;
import com.mall.service.api.VerifyCodeTemplateService;
import com.mall.util.SpringUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 验证码服务实现
 * @author suiguozhen on 19/01/24 10:39
 */
@Service
public class VerifyCodeSenderImpl implements VerifyCodeSender {

    @Value("${verifyCode.expire.time}")
    private Integer expireTime;

    @Value("${verifyCode.restrict.number}")
    private Integer restrictNumber;

    @Value("${verifyCode.send.length}")
    private Integer codeLength;

    @Autowired
    private VerifyCodeService verifyCodeService;

    @Autowired
    private VerifyCodeTemplateService verifyCodeTemplateService;

    @Autowired
    private SmsSender smsSender;

    @Override
    public Result<Void> sendSmsCode(String phone, VerifyCodeEnum verifyCodeEnum) {
        //查询发送总数
        VerifyCodeDto verifyCodeDto = verifyCodeService.getByPhoneAndType(phone, verifyCodeEnum);
        if(Objects.nonNull(verifyCodeDto)){
            if(verifyCodeDto.getCount()>=restrictNumber){
                return Result.failed(SpringUtil.getMessage("verifyCode.count.restrict"));
            }
        }
        //查询是否存在模板
        VerifyCodeTemplate verifyCodeTemplate = verifyCodeTemplateService.getByType(verifyCodeEnum);
        if(Objects.isNull(verifyCodeTemplate)){
            return Result.failed(SpringUtil.getMessage("verifyCode.template.isNull"));
        }
        String code=RandomStringUtils.randomNumeric(codeLength);
        smsSender.sendSms(phone,verifyCodeTemplate.getId());
        return Result.success();
    }

    @Override
    public Result<Void> sendEmailCode(String email, VerifyCodeEnum verifyCodeEnum) {
        return null;
    }
}
