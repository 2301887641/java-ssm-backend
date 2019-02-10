package com.mall.sender.pojo;

import com.mall.core.foundation.BasePojo;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * 验证码记录
 * @author suiguozhen on 19-1-27 下午7:36
 */
@Getter
@Setter
public class VerifyCodeRecord extends BasePojo {
    private Integer id;
    private Integer count;
    private String code;
    private String target;
    private VerifyCodeBusinessEnum verifyCodeType;
    private LocalDateTime sendTime;
    private LocalDateTime expireTime;
    private Boolean isChecked;
}
