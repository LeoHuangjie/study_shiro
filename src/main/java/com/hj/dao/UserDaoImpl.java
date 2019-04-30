package com.hj.dao;

import com.hj.entity.User;

import java.util.Set;

/**
 * @author huangjie
 * @time 2019-04-30 18:16
 */
public class UserDaoImpl implements UserDao {
    public User createUser(User user) {
        return null;
    }

    public void updateUser(User user) {

    }

    public void deleteUser(Long userId) {

    }

    public void correlationRoles(Long userId, Long... roleIds) {

    }

    public void uncorrelationRoles(Long userId, Long... roleIds) {

    }

    public User findOne(Long userId) {
        return null;
    }

    public User findByUsername(String username) {
        return null;
    }

    public Set<String> findRoles(String username) {
        return null;
    }

    public Set<String> findPermissions(String username) {
        return null;
    }
}
