package com.sweetmart.service;

import java.util.List;

import com.sweetmart.model.User;

public interface UserService {

	public User registerUser(User user);
	
	public User updateuser(User user,String key);
	
	public User deleteUser(int uid,String key);
	
	public List<User> getAllUser(String key);
	
}
