package com.mall.pojo;

import com.mall.enums.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author suiguozhen on 19-1-27 下午7:36
 */
@Getter
@Setter
public class VerifyCodeRecord extends BasePojo{
    private Integer count;
    private String code;
    private String phone;
    private VerifyCodeEnum verifyCodeType;
    private LocalDateTime expireTime;
    private VerifyCodeEnum verifyCodeEnum;
}
