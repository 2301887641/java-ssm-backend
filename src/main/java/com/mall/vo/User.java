package com.mall.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author suiguozhen on 19/01/19 14:46
 */
@Getter
@Setter
public class User {
    private Integer id;

    private String username;

    private String password;

    private String email;

    private String phone;

    private String question;

    private String answer;

    private Integer role;

    private Date createTime;

    private Date updateTime;
}
