/*
 * Copyright ©Adarsh Development Services
 * All Rights Reserved.
 */
package com.adarsh.spring.entity;


import javax.persistence.*;

/**
 * @author Adarsh
 * @author $LastChangedBy: adarsh $
 * @version $Revision: 0001 $, $Date:: 1/1/13 00:11 AM#$
 */
@Entity
@Table(name = "user_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="roleId" ,insertable = true, nullable = false, unique = true, updatable = true)
    protected Integer id;

    @Column(nullable = false, length = 40)
    private String roleName;

    public UserRole() {
    }

    public UserRole(String roleName) {
        this.roleName = roleName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
