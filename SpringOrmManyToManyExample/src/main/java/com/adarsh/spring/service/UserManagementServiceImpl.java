package com.adarsh.spring.service;

import com.adarsh.spring.entity.Permission;
import com.adarsh.spring.entity.User;
import com.adarsh.spring.entity.Groups;
import com.adarsh.spring.repository.GroupRepository;
import com.adarsh.spring.repository.PermissionRepository;
import com.adarsh.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:25 PM
 * This Class provide the implementation for the functionality of..
 */

@Service
public class UserManagementServiceImpl implements UserManagementService {

    @Autowired
    private UserRepository<User> userRepository;

    @Autowired
    private GroupRepository<Groups> groupRepository;

    @Autowired
    private PermissionRepository<Permission> permissionRepository;

    @Override
    @Transactional
    public User getUser(User user) {
        return this.userRepository.getUser(user);
    }

    @Override
    @Transactional
    public Permission getPermission(Permission permission) {
        return this.permissionRepository.getPermission(permission);
    }

    @Override
    @Transactional
    public Groups getGroup(Groups groups) {
        return this.groupRepository.getGroup(groups);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        this.userRepository.saveUser(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUsers(List<User> userList) {
       this.userRepository.saveUser(userList);
    }

    @Override
    @Transactional(readOnly = false)
    public void savePermission(Permission permission) {
        this.permissionRepository.savePermission(permission);
    }

    @Override
    @Transactional(readOnly = false)
    public void savePermission(List<Permission> permissionList) {
        this.permissionRepository.savePermissions(permissionList);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveGroup(Groups groups) {
        this.groupRepository.saveGroup(groups);
    }

    @Override
    @Transactional(readOnly = false)
    public void saveGroup(List<Groups> groupsList) {
        this.groupRepository.saveGroups(groupsList);
    }

    @Override
    @Transactional
    public List<User> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    @Transactional
    public List<Permission> getPermissions() {
        return this.permissionRepository.getPermissions();
    }

    @Override
    @Transactional
    public List<Groups> getGroup() {
        return this.groupRepository.getGroup();
    }
}
