package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.UserRespository;
import com.cande.punkbar.entity.User;

@Service
public class UserServiceImpl {

	
	@Autowired
	private UserRespository userRespository;
	
	public List<User> findAll() {
		return userRespository.findAll();
	}

	public User findById(int theId) {
		Optional<User> result = userRespository.findById(theId);
		User theUser = null;
		if(result.isPresent()) {
			theUser = result.get();
		}
		else {
			throw new RuntimeException("user id not found");
		}
		return theUser;
	}

	public void save(User theUser) {
		userRespository.save(theUser);
	}

	public void deleteById(int theId) {
		userRespository.deleteById(theId);
	}

	@Transactional
	public Optional<User> findByUsernameOrEmailAndPassword(String theUsername, String theEmail, String thePassword) {
		Optional<User> theUser = userRespository.findByUsernameOrEmailAndPassword(theUsername, theEmail, thePassword);
		return theUser;
	}

}
