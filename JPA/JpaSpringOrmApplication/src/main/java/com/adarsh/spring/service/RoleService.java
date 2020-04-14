package com.adarsh.spring.service;

import com.adarsh.spring.domain.Role;
import com.adarsh.spring.domain.User;
import com.adarsh.spring.repository.RoleRepository;
import com.adarsh.spring.repository.UserRepository;

import java.util.List;


public interface RoleService {

    public Role findByUserId(Long userId);

    public Role findByRoleName(String roleName);

    public List<Role> getAllRole();

    public void saveRole(Role role);

    public void deleteRole(Role role);

    public long count();

    public boolean roleExists(Role role);

    public void setRoleRepository(RoleRepository roleRepository);
}
