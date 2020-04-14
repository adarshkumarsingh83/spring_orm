package com.espark.adarsh.repository;

import com.espark.adarsh.entity.User;
import java.util.List;

public interface UserRepository {

	public List<User> list();
	
	public User get(int id);
	
	public void saveOrUpdate(User user);
	
	public void delete(int id);
}