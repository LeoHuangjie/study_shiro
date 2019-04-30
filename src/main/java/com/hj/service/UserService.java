package com.hj.service;

import com.hj.entity.User;

import java.util.Set;

/**
 * @author huangjie
 * @time 2019-04-30 17:53
 */
public interface UserService {
    User createUser (User user);

    void changePassword (Long userId, String newPassword);

    /**
     * 添加用户-角色关系
     * @param userId
     * @param roleIds
     */
    void correlationRoles(Long userId, Long... roleIds);

    /**
     * 删除用户-角色关系
     * @param userId
     * @param roleIds
     */
    void uncorrelationRoles (Long userId, Long... roleIds);

    /**
     * 通过用户名查找用户
     * @param userName
     * @return
     */
    User findByUserName (String userName);

    /**
     * 通过用户名查找角色
     * @param userName
     * @return
     */
    Set<String> findRoleByUserName (String userName);

    /**
     * 通过用户名查找权限
     * @param userName
     * @return
     */
    Set<String> findPermissionByUserName (String userName);
}
