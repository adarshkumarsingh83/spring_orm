package com.adarsh.spring.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 5:55 PM
 * This Class provide the implementation for the functionality of..
 */

@Entity
@Table(name = "Groups")
public class Groups implements Serializable {

    @Id
    @Column(name = "group_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupId;

    @Column(name = "group_name")
    private String groupName;

    @ManyToMany(targetEntity = User.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "User_Group"
            ,joinColumns = {@JoinColumn(name = "group_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> user=new HashSet<>();

    @ManyToMany(targetEntity = Permission.class, cascade = {CascadeType.ALL})
    @JoinTable(name = "Permission_Group"
            ,joinColumns = {@JoinColumn(name = "group_id")}
            ,inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissions=new HashSet<>();

    public Groups() {
    }

    public Groups(String groupName, Set<User> user) {
        this.groupName = groupName;
        this.user = user;
    }

    public Groups(String groupName, Set<User> user, Set<Permission> permissions) {
        this.groupName = groupName;
        this.user = user;
        this.permissions = permissions;
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

    public Set<User> getUser() {
        return user;
    }

    public void setUser(Set<User> user) {
        this.user = user;
    }


    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserGroup{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", user=" + user +
                ", permissions=" + permissions +
                '}';
    }
}
