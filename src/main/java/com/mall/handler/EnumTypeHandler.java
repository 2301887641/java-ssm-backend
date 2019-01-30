package com.mall.handler;

import com.mall.config.BaseEnumTypeHandler;
import com.mall.enums.BaseEnum;
import com.mall.enums.VerifyCodeBusinessEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author suiguozhen on 19/01/30 11:42
 */
@MappedTypes({
        VerifyCodeBusinessEnum.class
})
public class EnumTypeHandler<E extends BaseEnum> extends BaseEnumTypeHandler<E> {
}
