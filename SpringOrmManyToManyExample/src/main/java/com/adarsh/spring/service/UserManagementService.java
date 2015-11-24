package com.adarsh.spring.service;

import com.adarsh.spring.entity.Permission;
import com.adarsh.spring.entity.User;
import com.adarsh.spring.entity.Groups;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:23 PM
 * This Class provide the implementation for the functionality of..
 */

public interface UserManagementService {

    public User getUser(User user);

    public Permission getPermission(Permission permission);

    public Groups getGroup(Groups groups);

    public void saveUser(User user);

    public void saveUsers(List<User>  userList);

    public void savePermission(Permission permission);

    public void savePermission(List<Permission> permissionList);

    public void saveGroup(Groups groups);

    public void saveGroup(List<Groups> groupsList);

    public List<User> getUsers();

    public List<Permission> getPermissions();

    public List<Groups> getGroup();
}
