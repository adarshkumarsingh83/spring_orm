package com.adarsh.spring.service;


import com.adarsh.spring.entity.UserRole;
import com.adarsh.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired(required = true)
    private RoleRepository roleRepository;

    @Transactional
    @Override
    public UserRole getRoleByName(String roleName) {
        return this.roleRepository.findByRoleName(roleName);
    }

    @Transactional
    @Override
    public List<UserRole> getAllRoles() {
        return this.roleRepository.findAll();
    }

    @Transactional
    @Override
    public void saveRole(UserRole role) {
        this.roleRepository.save(role);
    }
}
