package com.hj.dao;

import com.hj.entity.User;

import java.util.Set;

/**
 * @author huangjie
 * @time 2019-04-30 18:15
 */
public interface UserDao {
    User createUser(User user);

    void updateUser(User user);

    void deleteUser(Long userId);

    void correlationRoles(Long userId, Long... roleIds);

    void uncorrelationRoles(Long userId, Long... roleIds);

    User findOne(Long userId);

    User findByUsername(String username);

    Set<String> findRoles(String username);

    Set<String> findPermissions(String username);
}
