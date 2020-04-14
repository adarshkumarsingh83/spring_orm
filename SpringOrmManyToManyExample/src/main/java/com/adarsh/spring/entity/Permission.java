package com.adarsh.spring.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 7:16 PM
 * This Class provide the implementation for the functionality of..
 */

@Entity
@Table(name="Permission")
public class Permission implements Serializable {

    @Id
    @Column(name="permission_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long permissionId;

    @Column(name = "permission_name")
    private String permissionName;

    public Permission() {
    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
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

    @Override
    public String toString() {
        return "Permission{" +
                "permissionId=" + permissionId +
                ", permissionName='" + permissionName + '\'' +
                '}';
    }
}
