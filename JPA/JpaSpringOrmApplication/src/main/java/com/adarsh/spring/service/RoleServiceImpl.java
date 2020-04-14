package com.adarsh.spring.service;

import com.adarsh.spring.domain.Role;
import com.adarsh.spring.domain.User;
import com.adarsh.spring.repository.RoleRepository;
import com.adarsh.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Scope(value = "singleton")
@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {


    @Override
    @Transactional(readOnly = true)
    public Role findByUserId(Long userId) {
        return roleRepository.findById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteRole(Role role) {
        roleRepository.delete(role);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return roleRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean roleExists(Role role) {
        return roleRepository.exists(role.getId());
    }

    @Autowired(required = true)
    private RoleRepository roleRepository;

    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
