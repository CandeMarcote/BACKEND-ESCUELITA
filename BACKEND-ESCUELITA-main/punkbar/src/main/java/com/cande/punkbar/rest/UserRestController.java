package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.User;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/api")
public class UserRestController {

	private UserService userService;

	//inject userDAO at the beginning but after we'll do it with a service
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	//Expose "/users" that returns a list of users
	@GetMapping("/users")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	//add mapping for GET /users/{userId}
	@GetMapping("/users/{userId}")
	public User getUser(@PathVariable int userId) {
		User theUser = userService.findById(userId);
		
		if(theUser == null) {
			throw new RuntimeException("User id not found: " + userId);
		}
		
		return theUser;
	}
	
	//adding mapping for POST /users - add new users
	@PostMapping("/users")
	public User addUser(@RequestBody User theUser) {
		//also just in case they pass an id in json ..set id to 0
		//this is to force a save of a new item ... instead of update
		
		theUser.setId(0);
		userService.save(theUser);
		
		return theUser;
	}
	
	// add mapping for updating users
	
	@PutMapping("/users")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}
	
	@DeleteMapping("/users/{userId}")
	public String deleteUser(@PathVariable int userId) {
		
		User theUser = userService.findById(userId);
		
		//throw exception if null
		if(theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
