package com.adarsh.spring.service;

import java.util.List;
import com.adarsh.spring.domain.User;
import org.springframework.stereotype.Service;
import com.adarsh.spring.repository.UserRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Scope(value = "singleton")
@Service(value = "userServiceImpl")
public class UserServiceImpl implements UserService{

    @Override
    @Transactional(readOnly = true)
    public User findByUserId(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return userRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public boolean userExists(User user) {
        return userRepository.exists(user.getId());
    }

    @Autowired(required = true)
    private UserRepository userRepository;

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
