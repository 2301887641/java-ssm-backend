package com.mall.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mall.group.userDto.ValidationUserDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Getter
@Setter
public class UserDto extends BaseDto{
    private Integer id;
    @NotNull(message="{validation.username.required}",groups = {
            ValidationUserDto.ValidationFrontUserLogin.class,
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String username;
    @NotNull(message="{validation.password.required}",groups = {
            ValidationUserDto.ValidationFrontUserLogin.class,
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    @JsonIgnore
    private String password;
    @NotNull(message="{validation.email.required}",groups = {
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String email;
    @NotNull(message="{validation.phone.required}",groups = {
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String phone;

    private String question;

    private String answer;

    private Integer role;
}