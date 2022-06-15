package com.cande.punkbar.dao;

import java.util.List;

import com.cande.punkbar.entity.User;

public interface UserDAO {
	
	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save(User theUser);
	
	public void deleteById(int theId);
}
