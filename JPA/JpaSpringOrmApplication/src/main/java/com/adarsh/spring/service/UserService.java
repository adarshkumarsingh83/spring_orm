package com.adarsh.spring.service;

import com.adarsh.spring.domain.User;
import com.adarsh.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface UserService {

    public User findByUserId(Long userId);

    public User findByUsername(String username);

    public List<User> getAllUser();

    public void saveUser(User user);

    public void deleteUser(User user);

   public long count();

    public boolean userExists(User user);

    public void setUserRepository(UserRepository userRepository);
}
