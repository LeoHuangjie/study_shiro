package com.hj.service;

import com.hj.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author huangjie
 * @time 2019-04-30 18:01
 * 在创建账户及修改密码时直接把生成密码操作委托给PasswordHelper。
 */
public class PasswordHalper {
    /**
     * 生成随机数
     */
    private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private final String algorithmName = "md5";

    /**
     * 可以设置hashIterations属性来修改默认加密迭代次数
     */
    private final int hashIterations = 2;

    public void encryptPassword (User user) {
        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        /**
         * 通过调用SimpleHash时指定散列算法，其内部使用了Java的MessageDigest实现。
         */
        SimpleHash simpleHash = new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(user.getCredentialsSalt()), hashIterations);

        String s = simpleHash.toHex();

        user.setPassword(s);
    }
}
