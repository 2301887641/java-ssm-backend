package com.mall.aspect;

import com.mall.common.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.lang.reflect.Method;

/**
 * 验证控制器参数aop
 * @author suiguozhen on 19-1-20 下午4:20
 */
@Component
@Aspect
public class ValidationAspect {

    @Pointcut("@annotation(com.mall.annotation.DoValidParam)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Errors errors;
        for (Object arg : args) {
            if(arg instanceof BeanPropertyBindingResult){
                errors=(BindingResult) arg;
               if(errors.hasErrors()){
                   FieldError fieldError = errors.getFieldError();
                   return Result.failed(fieldError.getDefaultMessage());
               }
            }
        }
        return point.proceed();
    }
}
