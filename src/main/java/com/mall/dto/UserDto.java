package com.mall.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Getter
@Setter
public class UserDto extends BaseDto{
    private Integer id;
    @NotNull(message="{validation.userDto.web.login.username}")
    private String username;
    @NotNull(message="{validation.userDto.web.login.password}")
    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;
}
