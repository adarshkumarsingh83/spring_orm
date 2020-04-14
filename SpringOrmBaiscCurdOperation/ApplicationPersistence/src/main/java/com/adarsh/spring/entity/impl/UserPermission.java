package com.adarsh.spring.entity.impl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adarsh on 7/10/15.
 */
@Entity
@Table(name = "user_permission")
public class UserPermission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_permission_id", unique = true, nullable = false)
    private Long userPermissionId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Users.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    private Users users;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Permission.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id", nullable = false)
    private Permission permission;


    public UserPermission() {
    }

    public Long getUserPermissionId() {
        return userPermissionId;
    }

    public void setUserPermissionId(Long userPermissionId) {
        this.userPermissionId = userPermissionId;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }


}
