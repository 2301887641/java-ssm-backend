package com.mall.sender.verifyCode.converter;

import com.mall.sender.verifyCode.dto.VerifyCodeDto;
import com.mall.sender.verifyCode.pojo.VerifyCode;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author suiguozhen on 19/01/29 15:18
 */
@Mapper
public interface VerifyCodeConverter{
    VerifyCodeConverter CONVERTER = Mappers.getMapper(VerifyCodeConverter.class);
    VerifyCodeDto pojoToDto(VerifyCode verifyCode);
    VerifyCode dtoToPojo(VerifyCodeDto verifyCodeDto);
}
