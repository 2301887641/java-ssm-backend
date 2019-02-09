package com.mall.context.advice;

import com.mall.context.util.SpringUtil;
import com.mall.core.exception.BusinessException;
import com.mall.core.exception.ConsoleLogException;
import com.mall.core.exception.NetworkException;
import com.mall.core.foundation.Result;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@Slf4j
public class UnificationExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(UnificationExceptionHandler.class);

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

    /**
     * 日志记录异常
     * @param exception ConsoleLogException记录无法避免的异常
     */
    @ExceptionHandler(ConsoleLogException.class)
    public void consoleLogExceptionHandler(ConsoleLogException exception){
        logger.info(exception.getMsg());
    }

    /**
     * 业务异常
     * @param exception 返回自定义的信息
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result<Void> businessExceptionHandler(BusinessException exception){
        return Result.failed(exception.getMsg());
    }

    /**
     * 只返回网络异常
     * @param exception 网络异常
     */
    @ExceptionHandler(NetworkException.class)
    @ResponseBody
    public Result<Void> networkExceptionHandler(NetworkException exception){
        logger.info(exception.getMsg());
        return Result.failed(SpringUtil.getMessage("exception.network.error"));
    }

    /**
     * 拦截剩余所有异常:事务失败
     * @param exception 所有异常
     * @return result
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Void> exceptionHandler(Exception exception){
        logger.info(exception.getMessage());
        return Result.failed(SpringUtil.getMessage("exception.network.error"));
    }
}
