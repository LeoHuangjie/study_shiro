package com.hj.service;


import com.hj.entity.Permission;

/**
 * @author huangjie
 * @time 2019-04-30 17:30
 */
public interface PermissionService {
    /**
     * 添加权限
     * @param permission
     * @return
     */
    Permission createPermission (Permission permission);

    /**
     * 删除权限
     * @param permissionId
     */
    void deletePermission (Long permissionId);
}
