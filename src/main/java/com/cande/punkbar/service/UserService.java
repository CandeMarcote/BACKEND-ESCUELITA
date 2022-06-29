package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import com.cande.punkbar.entity.User;

public interface UserService {

	public List<User> findAll();
	
	public User findById(int theId);
	
	public void save (User theUser);
	
	public void deleteById(int theId);
	
	public Optional<User> findByUsernameOrEmailAndPassword(String username, String email, String password);

}
