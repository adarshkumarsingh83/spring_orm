package com.adarsh.spring.repository;

import java.util.List;

/**
 * @Author Adarsh
 * @Product Lucas.
 * Created By: Adarsh
 * Created On Date: 2/2/2015  Time: 6:01 PM
 * This Class provide the implementation for the functionality of..
 */

public interface UserRepository <U>{

    public void saveUser(U user);

    public void saveUser(List<U> list);

    public U getUser(U user);

    public List<U> getUsers();

    public void updateUser(U user);

    public void deleteUser(U user);

}
