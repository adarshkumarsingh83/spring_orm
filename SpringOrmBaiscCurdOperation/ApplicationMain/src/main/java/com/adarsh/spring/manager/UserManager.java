package com.adarsh.spring.manager;

import com.adarsh.spring.entity.impl.Group;
import com.adarsh.spring.entity.impl.Permission;
import com.adarsh.spring.entity.impl.Users;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
public interface UserManager {

    public Users saveUser(final Users users);

    public Users updateUser(final Users users);

    public Users findUserByName(final String userName, boolean dependency);

    public boolean deleteUserByName(final String userName);


    public Permission savePermission(final Permission permission);

    public Permission updatePermission(final Permission permission);

    public Permission findPermissionByPermissionName(final String permissionName, boolean dependency);

    public boolean deletePermissionByName(final String permissionName);

    public Group saveGroup(final Group group);

    public Group updateGroup(final Group group);

    public Group findGroupByGroupName(final String groupName, boolean dependency);

    public boolean deleteGroupByName(final String groupName);


    public boolean deletePermissionForUser(final String userName, final String permissionName);

    public boolean deleteUserFromGroup(final String userName, final String groupName);

    public boolean deletePermissionFromGroup(final String groupName, final String permissionName);


    public List<Users> getAllUser(final boolean active,boolean dependency);

    public List<Group> getAllGroup(final boolean active,boolean dependency);

    public List<Permission> getAllPermission(final boolean active,boolean dependency);

}
