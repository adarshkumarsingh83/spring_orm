package com.adarsh.spring.service;


import com.adarsh.spring.entity.User;
import com.adarsh.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = true)
    private UserRepository userRepository;

    @Transactional
    @Override
    public User getUserByName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Transactional
    @Override
    public List<User> getAllUser() {
        return this.userRepository.findAll();
    }

    @Transactional(readOnly = false)
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }
}
