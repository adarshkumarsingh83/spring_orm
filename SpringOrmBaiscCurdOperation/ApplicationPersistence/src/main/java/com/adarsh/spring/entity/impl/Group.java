package com.adarsh.spring.entity.impl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
@Entity
@Table(name = "group")
public class Group extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_id", unique = true, nullable = false)
    private Long groupId;

    @Column(name = "group_name", unique = true, nullable = false)
    private String groupName;

  /*  @OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<UserGroup> userGroups = new ArrayList<UserGroup>();
*/
    @Transient
    private List<Users> usersList = new ArrayList<Users>();

    /*@OneToMany(mappedBy = "group", fetch = FetchType.LAZY)
    private List<GroupPermission> groupPermissions = new ArrayList<GroupPermission>();
*/
    @Transient
    private List<Permission> permissionList = new ArrayList<Permission>();

    public Group() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

  /*  public List<UserGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<UserGroup> userGroups) {
        this.userGroups = userGroups;
    }

    public List<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }
*/
    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    public void setUsers(Users users) {
        this.usersList.add(users);
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(Permission permission) {
        this.permissionList.add(permission);
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissionList = permissions;
    }


}
