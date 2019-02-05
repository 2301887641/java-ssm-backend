package com.mall.converter;

import com.mall.dto.UserDto;
import com.mall.dao.pojo.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author suiguozhen on 19-1-20 下午3:40
 */
@Mapper
public interface UserConverter {
    UserConverter CONVERTER = Mappers.getMapper(UserConverter.class);
    UserDto pojoToDto(User user);
    User dtoToPojo(UserDto dto);
}