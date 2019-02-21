package com.mall.dao.handler;

import com.mall.core.foundation.BaseEnum;
import com.mall.core.foundation.BaseEnumTypeHandler;
import com.mall.sender.enums.VerifyCodeBusinessEnum;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author suiguozhen on 19/01/30 11:42
 */
@MappedTypes({
        VerifyCodeBusinessEnum.class
})
public class EnumTypeHandler<E extends BaseEnum> extends BaseEnumTypeHandler<E> {
    public EnumTypeHandler(Class<E> type) {
        super(type);
    }
}
