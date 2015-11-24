package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.UserPermission;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
public interface UserPermissionRepository {

    public UserPermission saveUserPermission(final UserPermission userPermission);

    public UserPermission updateUserPermission(final UserPermission userPermission);

    public UserPermission findUserPermissionById(final Long userPermissionId);

    public boolean deleteUserPermission(final UserPermission userPermission);

    public List<UserPermission> findUserPermissionByPermissionId(final Long permissionId);

    public List<UserPermission> findUserPermissionByUserId(final Long userId);

    public UserPermission findUserPermissionByUserIdAndPermissionId(final Long userId,final Long permissionId);

    public UserPermission findUserPermissionByUserNameAndPermissionName(final String userName,final String permissionName);
}
