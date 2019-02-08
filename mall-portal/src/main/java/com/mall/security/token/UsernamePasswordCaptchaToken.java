package com.mall.security.token;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author suiguozhen on 19-2-8 上午10:25
 */
@Getter
@Setter
public class UsernamePasswordCaptchaToken extends UsernamePasswordToken {
    private String captcha;
    public UsernamePasswordCaptchaToken(String username, String password,
                                        boolean rememberMe, String host,String captcha) {
        super(username, password, rememberMe, host);
        this.captcha = captcha;
    }
}
