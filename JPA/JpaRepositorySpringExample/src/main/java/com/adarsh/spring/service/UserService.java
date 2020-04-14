package com.adarsh.spring.service;



import com.adarsh.spring.entity.User;

import java.util.List;

/**
 * Created by Adarsh on 3/21/15.
 */
public interface UserService {

    public User getUserByName(String userName);

    public List<User> getAllUser();

    public void saveUser(User user);
}
