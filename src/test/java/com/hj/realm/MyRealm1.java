package com.hj.realm;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.Realm;

/**
 * @author huangjie
 * @time 2019-04-28 17:34
 */
public class MyRealm1 implements Realm {
    public String getName() {
        //返回一个唯一的Realm名字
        return "myRealm1";
    }

    public boolean supports(AuthenticationToken authenticationToken) {
        //判断此Realm是否支持此Token
        return authenticationToken instanceof UsernamePasswordToken;
    }

    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据Token获取认证信息


        //得到用户名
        String userName = (String) authenticationToken.getPrincipal();

        //得到密码
        String passWord = new String((char[])authenticationToken.getCredentials());

        if (!"huang".equals(userName)) {
            throw new UnknownAccountException();
        }

        if (!"123".equals(passWord)) {
            throw new IncorrectCredentialsException();
        }

        //如果身份认证验证成功，返回一个AuthenticationInfo实现；
        return new SimpleAuthenticationInfo(userName,passWord,getName());
    }
}
