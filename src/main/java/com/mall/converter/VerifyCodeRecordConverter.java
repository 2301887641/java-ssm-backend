package com.mall.converter;

import com.mall.dto.VerifyCodeRecordDto;
import com.mall.pojo.VerifyCodeRecord;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author suiguozhen on 19-1-27 下午8:17
 */
@Mapper
public interface VerifyCodeRecordConverter {
    VerifyCodeRecordConverter converter= Mappers.getMapper(VerifyCodeRecordConverter.class);
    VerifyCodeRecord dtoToPojo(VerifyCodeRecordDto verifyCodeRecordDto);
    VerifyCodeRecordDto pojoTodto(VerifyCodeRecord verifyCodeRecord);
}
