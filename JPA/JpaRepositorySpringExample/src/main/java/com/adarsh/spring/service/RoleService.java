package com.adarsh.spring.service;


import com.adarsh.spring.entity.UserRole;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
public interface RoleService {

    public UserRole getRoleByName(String roleName);

    public List<UserRole> getAllRoles();

    public void saveRole(UserRole role);
}
