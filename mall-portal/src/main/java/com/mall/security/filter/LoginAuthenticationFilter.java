package com.mall.security.filter;

import com.mall.core.constant.ConstantsPool;
import com.mall.core.exception.BusinessException;
import com.mall.core.foundation.Result;
import com.mall.dao.enums.VerifyCodeTypeEnum;
import com.mall.security.exception.IncorrectCaptchaException;
import com.mall.security.token.UsernamePasswordCaptchaToken;
import com.mall.service.api.VerifyCodeService;
import com.mall.service.dto.VerifyCodeRecordDto;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截 Form表单的身份验证过滤器
 *
 * @author suiguozhen on 19-2-7 下午7:30
 */
@Getter
@Setter
public class LoginAuthenticationFilter extends FormAuthenticationFilter {

    private static final String DEFAULT_CAPTCHA_PARAM = "captcha";

    private String captchaParam = DEFAULT_CAPTCHA_PARAM;

    @Autowired
    private VerifyCodeService verifyCodeService;

    private String getCaptcha(ServletRequest request) {
        return WebUtils.getCleanParam(request, getCaptchaParam());
    }

    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        UsernamePasswordCaptchaToken token = createToken(request, response);
        try {
            doCaptchaValidate( (HttpServletRequest)request,token );
            Subject subject = getSubject(request, response);
            subject.login(token);
            return onLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            return onLoginFailure(token, e, request, response);
        }
    }

    @Override
    protected UsernamePasswordCaptchaToken createToken(ServletRequest request, ServletResponse response) {
        return new UsernamePasswordCaptchaToken(getUsername(request), getPassword(request), isRememberMe(request), getHost(request), getCaptcha(request));
    }

    // 验证码校验
    private void doCaptchaValidate( HttpServletRequest request,UsernamePasswordCaptchaToken token ){
        VerifyCodeRecordDto verifyCodeRecordDto = (VerifyCodeRecordDto) request.getSession().getAttribute(ConstantsPool.Session.CAPTCHA_SESSION_NAME);
            Result<Void> validate = verifyCodeService.validate(VerifyCodeTypeEnum.CAPTCHA, verifyCodeRecordDto, token.getCaptcha());
            if(!validate.isSuccess()){
                throw new IncorrectCaptchaException("验证码错误！");
            }
    }
}
