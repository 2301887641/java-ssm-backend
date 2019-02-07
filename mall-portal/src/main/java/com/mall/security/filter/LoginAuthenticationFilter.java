package com.mall.security.filter;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 登录拦截 Form表单的身份验证过滤器
 * @author suiguozhen on 19-2-7 下午7:30
 */
public class LoginAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        return super.executeLogin(request, response);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpSession session = httpServletRequest.getSession();
        String captcha = httpServletRequest.getParameter("captcha");
        if(StringUtils.isNotBlank(captcha)){

        }
        return super.onAccessDenied(request, response);
    }
}
