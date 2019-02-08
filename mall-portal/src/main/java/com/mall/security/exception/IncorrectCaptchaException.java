package com.mall.security.exception;

import org.apache.shiro.authc.AuthenticationException;

/**
 * 验证码不正确异常
 * @author suiguozhen on 19-2-8 上午10:40
 */
public class IncorrectCaptchaException extends AuthenticationException {
    public IncorrectCaptchaException() {
        super();
    }

    public IncorrectCaptchaException(String message, Throwable cause) {
        super(message, cause);
    }

    public IncorrectCaptchaException(String message) {
        super(message);
    }

    public IncorrectCaptchaException(Throwable cause) {
        super(cause);
    }
}
