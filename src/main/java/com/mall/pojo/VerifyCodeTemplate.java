package com.mall.pojo;

import com.mall.enums.VerifyCodeEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suiguozhen on 19/01/24 16:25
 */
@Getter
@Setter
public class VerifyCodeTemplate extends BasePojo{
    private Integer id;
    private String content;
    private VerifyCodeEnum verifyCodeEnum;
}
