package com.mall.dto;

import com.mall.enums.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suiguozhen on 19-1-27 下午7:35
 */
@Getter
@Setter
public class VerifyCodeRecordDto extends BaseDto{
    private Integer count;
    private String code;
    private String phone;
    private VerifyCodeEnum verifyCodeEnum;
}
