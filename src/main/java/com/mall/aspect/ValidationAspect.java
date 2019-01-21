package com.mall.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 *  @author suiguozhen on 19-1-20 下午4:20
 */
@Component
@Aspect
public class ValidationAspect {

    @Pointcut("@annotation(com.mall.annotation.ValidationParam)")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println(123);
    }
}
