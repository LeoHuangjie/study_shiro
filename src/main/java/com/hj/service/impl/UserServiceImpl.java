package com.hj.service.impl;

import com.hj.entity.User;
import com.hj.service.UserService;

import java.util.Set;

/**
 * @author huangjie
 * @time 2019-04-30 17:59
 */
public class UserServiceImpl implements UserService {
    public User createUser(User user) {
        return null;
    }

    public void changePassword(Long userId, String newPassword) {

    }

    public void correlationRoles(Long userId, Long... roleIds) {

    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    public User findByUserName(String userName) {
        return null;
    }

    public Set<String> findRoleByUserName(String userName) {
        return null;
    }

    public Set<String> findPermissionByUserName(String userName) {
        return null;
    }
}
