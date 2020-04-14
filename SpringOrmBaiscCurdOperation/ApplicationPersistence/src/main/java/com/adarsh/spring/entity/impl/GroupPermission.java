package com.adarsh.spring.entity.impl;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Adarsh on 7/10/15.
 */
@Entity
@Table(name = "group_permission")
public class GroupPermission extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_permission_id", unique = true, nullable = false)
    private Long groupPermissionId;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Permission.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "permission_id", referencedColumnName = "permission_id", nullable = false)
    private Permission permission;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Group.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "group_id", referencedColumnName = "group_id", nullable = false)
    private Group group;


    public GroupPermission() {
    }

    public Long getGroupPermissionId() {
        return groupPermissionId;
    }

    public void setGroupPermissionId(Long groupPermissionId) {
        this.groupPermissionId = groupPermissionId;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }


}
