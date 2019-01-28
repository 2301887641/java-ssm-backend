package com.mall.controller;

import com.mall.common.Result;
import com.mall.controller.util.SpringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

/**
 * @author suiguozhen on 19/01/26 13:34
 */
@ControllerAdvice
@Controller
public class UnificationExceptionHandler {

    /**
     * 方法参数校验
     * @param exception 异常类
     * @return Result
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result<Void> constraintViolationExceptionHandler(ConstraintViolationException exception){
        Set<ConstraintViolation<?>> constraintViolations = exception.getConstraintViolations();
        for(ConstraintViolation<?> item:constraintViolations){
            return Result.failed(item.getMessage());
        }
        return Result.failed(SpringUtil.getMessage("exception.network.error"));
    }
}
