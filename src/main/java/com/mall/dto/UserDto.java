package com.mall.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 * @author suiguozhen on 19/01/19 14:46
 */
@Getter
@Setter
public class UserDto extends BaseDto{
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String email;
    private String question;
    private String answer;
    private Integer role;

    public static UserDto of(String username,String nickname,String password){
        UserDto userDto = new UserDto();
        userDto.setNickname(nickname);
        userDto.setPassword(password);
        userDto.setUsername(username);
        return userDto;
    }
}