package com.adarsh.spring.repository;

import com.adarsh.spring.entity.impl.Users;

import java.util.List;

/**
 * Created by Adarsh on 7/10/15.
 */
public interface UserRepository {

    public Users saveUser(final Users users);

    public Users updateUser(final Users users);

    public Users findUserById(final Long userId);

    public boolean deleteUser(final Users users);

    public Users findUserByName(final String userName);

    public List<Users> getAllUser(final boolean active);

}
