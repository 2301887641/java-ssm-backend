package com.mall.security.realm;

import com.mall.service.api.UserService;
import com.mall.service.dto.UserDto;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Objects;

/**
 * 自定义用户名和密码验证码realm
 * @author suiguozhen on 19-2-7 上午10:09
 */
public class UsernamePasswordCaptchaRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        UserDto userDto = userService.getByUsername(usernamePasswordToken.getUsername());
        if(Objects.isNull(userDto)){
            return
        }
        // 获取用户名
        String userName = (String) authenticationToken.getPrincipal();
        return new SimpleAuthenticationInfo();
    }
}
