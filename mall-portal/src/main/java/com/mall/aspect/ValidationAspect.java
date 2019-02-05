package com.mall.aspect;

import com.mall.core.message.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;

/**
 * 验证控制器参数aop
 * @author suiguozhen on 19-1-20 下午4:20
 */
@Component
@Aspect
public class ValidationAspect {

    @Pointcut("@annotation(com.mall.annotation.DoValid)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        for (Object arg : point.getArgs()) {
            if(arg instanceof BeanPropertyBindingResult){
                Errors errors=(BindingResult) arg;
               if(errors.hasErrors()){
                   return Result.failed(errors.getFieldError().getDefaultMessage());
               }
            }
        }
        return point.proceed();
    }
}
