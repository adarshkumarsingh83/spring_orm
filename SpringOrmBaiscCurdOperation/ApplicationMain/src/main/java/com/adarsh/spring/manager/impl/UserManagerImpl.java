package com.adarsh.spring.manager.impl;

import com.adarsh.spring.entity.impl.*;
import com.adarsh.spring.manager.UserManager;
import com.adarsh.spring.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserManagerImpl implements UserManager {

    @Qualifier(value = "userRepositoryImpl")
    @Autowired(required = true)
    private UserRepository userRepository;

    @Qualifier(value = "permissionRepositoryImpl")
    @Autowired(required = true)
    private PermissionRepository permissionRepository;

    @Qualifier(value = "groupRepositoryImpl")
    @Autowired(required = true)
    private GroupRepository groupRepository;

    @Qualifier(value = "userGroupRepositoryImpl")
    @Autowired(required = true)
    private UserGroupRepository userGroupRepository;

    @Qualifier(value = "userPermissionRepositoryImpl")
    @Autowired(required = true)
    private UserPermissionRepository userPermissionRepository;

    @Qualifier(value = "groupPermissionRepositoryImpl")
    @Autowired(required = true)
    private GroupPermissionRepository groupPermissionRepository;


    @Transactional(readOnly = false)
    @Override
    public Users saveUser(Users users) {
        return this.userRepository.saveUser(users);
    }

    @Transactional(readOnly = false)
    @Override
    public Users updateUser(Users users) {
        return this.userRepository.updateUser(users);
    }

    @Transactional(readOnly = false)
    @Override
    public Permission savePermission(Permission permission) {
        return this.permissionRepository.savePermission(permission);
    }

    @Transactional(readOnly = false)
    @Override
    public Permission updatePermission(Permission permission) {
        return this.permissionRepository.updatePermission(permission);
    }

    @Transactional(readOnly = false)
    @Override
    public Group saveGroup(Group group) {
        return this.groupRepository.saveGroup(group);
    }

    @Transactional(readOnly = false)
    @Override
    public Group updateGroup(Group group) {
        return this.groupRepository.updateGroup(group);
    }

    @Transactional(readOnly = true)
    @Override
    public Users findUserByName(String userName, boolean dependency) {
        final Users users = this.userRepository.findUserByName(userName);
        if (dependency && users != null) {
            final List<UserGroup> userGroups = this.userGroupRepository.findUserGroupByUserId(users.getUserId());
            if (userGroups != null && !userGroups.isEmpty()) {
                final List<Group> userGroupList = new ArrayList<Group>(userGroups.size());
                for (UserGroup userGroup : userGroups) {
                    userGroupList.add(userGroup.getGroup());
                }
                users.setUserGroup(userGroupList);
            }
            final List<UserPermission> userPermissions = this.userPermissionRepository.findUserPermissionByUserId(users.getUserId());
            if (userPermissions != null && !userPermissions.isEmpty()) {
                final List<Permission> userPermissionsList = new ArrayList<Permission>(userPermissions.size());
                for (UserPermission userPermission : userPermissions) {
                    userPermissionsList.add(userPermission.getPermission());
                }
                users.setUserPermission(userPermissionsList);
            }
        }
        return users;
    }

    @Transactional(readOnly = true)
    @Override
    public Permission findPermissionByPermissionName(String permissionName, boolean dependency) {
        final Permission permission = this.permissionRepository.findByPermissionName(permissionName);
        if (dependency && permission != null) {
            final List<GroupPermission> groupPermissions = this.groupPermissionRepository.findGroupPermissionByPermissionId(permission.getPermissionId());
            if (groupPermissions != null && !groupPermissions.isEmpty()) {
                final List<Group> groupList = new ArrayList<Group>(groupPermissions.size());
                for (GroupPermission groupPermission : groupPermissions) {
                    groupList.add(groupPermission.getGroup());
                }
                permission.setGroups(groupList);
            }
            final List<UserPermission> userPermissions = this.userPermissionRepository.findUserPermissionByPermissionId(permission.getPermissionId());
            if (userPermissions != null && !userPermissions.isEmpty()) {
                final List<Users> usersList = new ArrayList<Users>(userPermissions.size());
                for (UserPermission userPermission : userPermissions) {
                    usersList.add(userPermission.getUsers());
                }
                permission.setUsers(usersList);
            }
        }
        return permission;
    }

    @Transactional(readOnly = true)
    @Override
    public Group findGroupByGroupName(String groupName, boolean dependency) {
        final Group group = this.groupRepository.findGroupByName(groupName);
        if (dependency && group != null) {
            final List<UserGroup> userGroups = this.userGroupRepository.findUserGroupByGroupId(group.getGroupId());
            if (userGroups != null && !userGroups.isEmpty()) {
                final List<Users> usersList = new ArrayList<Users>(userGroups.size());
                for (UserGroup userGroup : userGroups) {
                    usersList.add(userGroup.getUsers());
                }
                group.setUsersList(usersList);
            }
            final List<GroupPermission> groupPermissions = this.groupPermissionRepository.findGroupPermissionByGroupId(group.getGroupId());
            if (groupPermissions != null && !groupPermissions.isEmpty()) {
                final List<Permission> permissionList = new ArrayList<Permission>(groupPermissions.size());
                for (GroupPermission groupPermission : groupPermissions) {
                    permissionList.add(groupPermission.getPermission());
                }
                group.setPermissions(permissionList);
            }
        }
        return group;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deleteUserByName(String userName) {
        final Users users = this.userRepository.findUserByName(userName);
        if (users != null) {
            return this.userRepository.deleteUser(users);
        }
        return false;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deletePermissionByName(String permissionName) {
        final Permission permission = this.permissionRepository.findByPermissionName(permissionName);
        if (permission != null) {
            return this.permissionRepository.deletePermission(permission);
        }
        return false;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deleteGroupByName(String groupName) {
        final Group group = this.groupRepository.findGroupByName(groupName);
        if (group != null) {
            return this.groupRepository.deleteGroup(group);
        }
        return false;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deletePermissionForUser(String userName, String permissionName) {
        final UserPermission userPermission = this.userPermissionRepository.findUserPermissionByUserNameAndPermissionName(userName, permissionName);
        if (userPermission != null) {
            this.userPermissionRepository.deleteUserPermission(userPermission);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deleteUserFromGroup(String userName, String groupName) {
        final UserGroup userGroup = this.userGroupRepository.findUserGroupByGroupNameAndUserName(groupName, userName);
        if (userGroup != null) {
            this.userGroupRepository.deleteUserGroup(userGroup);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean deletePermissionFromGroup(String groupName, String permissionName) {
        final GroupPermission groupPermission = this.groupPermissionRepository.findGroupPermissionByPermissionNameAndGroupName(permissionName, groupName);
        if (groupPermission != null) {
            this.groupPermissionRepository.deleteGroupPermission(groupPermission);
            return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Users> getAllUser(boolean active, boolean dependency) {
        final List<Users> usersList = this.userRepository.getAllUser(active);
        if (dependency && usersList != null && !usersList.isEmpty()) {
            final List<Users> usersListWithDependency = new ArrayList<Users>(usersList.size());
            for (Users users : usersList) {
                usersListWithDependency.add(this.findUserByName(users.getUserName(), true));
            }
            return usersListWithDependency;
        }
        return usersList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Group> getAllGroup(boolean active, boolean dependency) {
        final List<Group> groupList = this.groupRepository.getAllGroup(active);
        if (dependency && groupList != null && !groupList.isEmpty()) {
            final List<Group> groupListWithDependency = new ArrayList<Group>(groupList.size());
            for (Group group : groupList) {
                groupListWithDependency.add(this.findGroupByGroupName(group.getGroupName(), true));
            }
            return groupListWithDependency;
        }
        return groupList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Permission> getAllPermission(boolean active, boolean dependency) {
        final List<Permission> permissionList = this.permissionRepository.getAllPermission(active);
        if (dependency && permissionList != null && !permissionList.isEmpty()) {
            final List<Permission> permissionListWithDependency = new ArrayList<Permission>(permissionList.size());
            for (Permission permission : permissionList) {
                permissionListWithDependency.add(this.findPermissionByPermissionName(permission.getPermissionName(), true));
            }
            return permissionListWithDependency;
        }
        return permissionList;
    }
}
