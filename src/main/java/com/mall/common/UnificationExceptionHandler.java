package com.mall.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;

/**
 * @author suiguozhen on 19/01/26 13:34
 */
@ControllerAdvice
@Controller
public class UnificationExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public Result<Void> illegalArgumentExceptionHandler(ConstraintViolationException exception, HttpServletRequest request, HttpServletResponse response){
        return Result.failed(exception.getMessage());
    }
}
