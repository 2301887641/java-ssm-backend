package com.mall.dao.pojo;

import com.mall.core.foundation.BasePojo;
import lombok.Getter;
import lombok.Setter;

/**
 * 用户
 * @author suiguozhen on 19/01/19 14:46
 */
@Getter
@Setter
public class User extends BasePojo {
    private Integer id;
    private String nickname;
    private String username;
    private String password;
    private String email;
}
