package com.adarsh.spring.repository;

import com.adarsh.spring.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUserName(String userName);
}
