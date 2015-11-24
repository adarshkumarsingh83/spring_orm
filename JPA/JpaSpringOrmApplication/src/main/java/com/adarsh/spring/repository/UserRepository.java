package com.adarsh.spring.repository;

import com.adarsh.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

    public User findById(Long userId);

    public User findByUsername(String username);

}
