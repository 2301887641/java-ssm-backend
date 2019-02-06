package com.mall.dao.pojo;

import com.mall.core.foundation.BasePojo;
import com.mall.dao.enums.VerifyCodeBusinessEnum;
import lombok.Getter;
import lombok.Setter;

/**
 * @author suiguozhen on 19/01/24 11:01
 */
@Getter
@Setter
public class VerifyCode extends BasePojo {
    private Integer id;
    private VerifyCodeBusinessEnum verifyCodeType;
    private String template;
    private String templateName;
}
