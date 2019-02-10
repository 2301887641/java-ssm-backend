package com.mall.sender.converter;

import com.mall.sender.pojo.VerifyCode;
import com.mall.sender.dto.VerifyCodeDto;
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
