package com.adarsh.spring.entity.impl;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
@Entity
@Table(name = "users")
public class Users extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    private Long userId;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_pwd", nullable = false)
    private String userPwd;

/*    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();*/

    @Transient
    private List<Group> groupList = new ArrayList<Group>();

    /*@OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<UserPermission> userPermissions = new ArrayList<UserPermission>();
*/
    @Transient
    private List<Permission> permissionList = new ArrayList<Permission>();


    public Users() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

   /* public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public List<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }*/

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(Group group) {
        this.groupList.add(group);
    }

    public void setUserGroup(List<Group> userGroup) {
        this.groupList = userGroup;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Permission permission) {
        this.permissionList.add(permission);
    }

    public void setUserPermission(List<Permission> userPermission) {
        this.permissionList = userPermission;
    }


}
