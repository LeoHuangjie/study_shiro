package com.hj.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author huangjie
 * @time 2019-04-28 17:26
 */
public class AuthenticatorTest {

    private void login (String configFile) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        SecurityManager instance = factory.getInstance();
        SecurityUtils.setSecurityManager(instance);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken huang = new UsernamePasswordToken("huang", "123");

        subject.login(huang);
    }



    @Test
    public void testAllSuccessfulStrategyWithSuccess () {
        login("classpath:shiro-authenticator-all-success.ini");

        Subject subject = SecurityUtils.getSubject();

        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principals = subject.getPrincipals();


        Assert.assertEquals(2,principals.getRealmNames().size());

    }


    @Test
    public void testAllSuccessfulStrategyWithFail () {
        login("classpath:shiro-authenticator-all-fail.ini");
        Subject subject = SecurityUtils.getSubject();
        //得到一个身份集合，其包含了Realm验证成功的身份信息
        PrincipalCollection principals = subject.getPrincipals();


        Assert.assertEquals(1,principals.getRealmNames().size());
    }
}
