package com.revature.service;

import com.revature.model.User;

public interface UserService {
	
	//create
	public boolean createAccount(User user);
	
	//find username by id number
	public User findUsernameById(int id);
	
	//update info
	public boolean editUser(User user);
	
	//delete
	public boolean deleteUser(User user);
	/*
	 * Manager should 
	 * 
	 * */
}
