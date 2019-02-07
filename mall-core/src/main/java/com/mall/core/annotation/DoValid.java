package com.mall.core.annotation;

import java.lang.annotation.*;

/**
 * 参数校验
 * @author suiguozhen on 19-1-20 下午4:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DoValid {
}
