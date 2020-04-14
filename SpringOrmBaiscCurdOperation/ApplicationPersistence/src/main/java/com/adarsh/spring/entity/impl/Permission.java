package com.adarsh.spring.entity.impl;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
@Entity
@Table(name = "permission")
public class Permission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permission_id", unique = true, nullable = false)
    private Long permissionId;

    @Column(name = "permission_name", unique = true, nullable = false)
    private String permissionName;

  /*  @OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private List<GroupPermission> groupPermissions = new ArrayList<GroupPermission>();*/

    @Transient
    private List<Group> groupList = new ArrayList<Group>();

    /*@OneToMany(mappedBy = "permission", fetch = FetchType.LAZY)
    private List<UserPermission> userPermissions = new ArrayList<UserPermission>();
*/
    @Transient
    private List<Users> usersList = new ArrayList<Users>();



    public Permission() {
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

   /* public List<GroupPermission> getGroupPermissions() {
        return groupPermissions;
    }

    public void setGroupPermissions(List<GroupPermission> groupPermissions) {
        this.groupPermissions = groupPermissions;
    }

    public List<UserPermission> getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(List<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }
*/
    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(Group group) {
        this.groupList.add(group);
    }

    public void setGroups(List<Group> groups) {
        this.groupList = groups;
    }

    public List<Users> getUsersList() {
        return usersList;
    }

    public void setUsersList(Users usersList) {
        this.usersList.add(usersList);
    }

    public void setUsers(List<Users> users) {
        this.usersList = users;
    }


}
