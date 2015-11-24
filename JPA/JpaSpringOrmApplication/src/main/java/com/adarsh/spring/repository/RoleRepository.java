package com.adarsh.spring.repository;

import com.adarsh.spring.domain.Role;
import com.adarsh.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository< Role, Long> {

    public  Role findById(Long roleId);

    public Role findByRoleName(String roleName);

}
