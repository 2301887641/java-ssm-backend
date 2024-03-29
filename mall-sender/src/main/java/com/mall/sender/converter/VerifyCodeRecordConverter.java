package com.mall.sender.converter;

import com.mall.sender.dto.VerifyCodeRecordDto;
import com.mall.sender.pojo.VerifyCodeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author suiguozhen on 19-1-27 下午8:17
 */
@Mapper
public interface VerifyCodeRecordConverter {
    VerifyCodeRecordConverter CONVERTER= Mappers.getMapper(VerifyCodeRecordConverter.class);
    VerifyCodeRecord dtoToPojo(VerifyCodeRecordDto verifyCodeRecordDto);
    VerifyCodeRecordDto pojoToDto(VerifyCodeRecord verifyCodeRecord);
}
