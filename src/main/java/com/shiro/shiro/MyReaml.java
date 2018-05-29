package com.shiro.shiro;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

/**
 * Created by Administrator on 2018/5/29.
 */
public class MyReaml extends AuthorizingRealm{
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        //获取用胡输入的账号信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)authenticationToken;
       //模拟数据库的信息
        String name = "lizhen";
        String password = "1234";

        if (!usernamePasswordToken.getUsername().equals(name)){
            return null;
        }
       SecurityProperties.User user = new SecurityProperties.User();
        user.setName(name);
        user.setPassword(password);
        //将此返回，会自动校验密码是否正确
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), "");
        return simpleAuthenticationInfo;
    }
}
