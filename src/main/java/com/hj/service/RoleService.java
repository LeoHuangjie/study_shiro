package com.hj.service;

import com.hj.entity.Role;

/**
 * @author huangjie
 * @time 2019-04-30 17:49
 */
public interface RoleService {
    Role addRole (Role role);

    void deleteRole (Long roleId);

    /**
     *  添加角色-权限之间关系
     */
    void correlationPermissions (Long roleId, Long... permissionIds);

    /**
     * 删除角色-权限之间关系
     */
    void uncorrelationPermissions (Long roleId, Long... permissionIds);
}
