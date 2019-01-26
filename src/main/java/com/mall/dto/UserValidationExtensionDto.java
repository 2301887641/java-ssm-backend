package com.mall.dto;

import com.mall.group.userDto.ValidationUserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * 用户验证扩展dto
 * @author suiguozhen on 19/01/26 15:25
 */
@Getter
@Setter
public class UserValidationExtensionDto {
    @NotNull(message="{validation.captcha.isNull}",groups = {
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String captcha;
}
