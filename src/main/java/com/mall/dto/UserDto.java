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
    @NotNull(message="{validation.userDto.username.required}",groups = {
            ValidationUserDto.ValidationFrontUserLogin.class,
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String username;
    @NotNull(message="{validation.userDto.password.required}",groups = {
            ValidationUserDto.ValidationFrontUserLogin.class,
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    @JsonIgnore
    private String password;
    @NotNull(message="{validation.userDto.email.required}",groups = {
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String email;
    @NotNull(message="{validation.userDto.phone.required}",groups = {
            ValidationUserDto.ValidationFrontUserRegister.class
    })
    private String phone;

    private String question;

    private String answer;

    private Integer role;
}