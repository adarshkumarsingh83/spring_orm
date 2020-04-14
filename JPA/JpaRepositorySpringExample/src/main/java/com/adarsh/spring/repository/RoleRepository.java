package com.adarsh.spring.repository;

import com.adarsh.spring.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Adarsh on 3/21/15.
 */
public interface RoleRepository extends JpaRepository<UserRole,Long> {

    public UserRole findByRoleName(String roleName);
}
