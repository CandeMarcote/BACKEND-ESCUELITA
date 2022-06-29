package com.cande.punkbar.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.User;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserRestController {

	private UserService userService;

	//inject userDAO at the beginning but after we'll do it with a service
	@Autowired
	public UserRestController(UserService theUserService) {
		userService = theUserService;
	}
	//Expose "/users" that returns a list of users
	@CrossOrigin
	@GetMapping("/")
	public List<User> findAll(){
		return userService.findAll();
	}
	
	//add mapping for GET /users/{userId}
	@GetMapping("/{userId}")
	public User getUser(@RequestParam int userId) {
		User theUser = userService.findById(userId);
		
		if(theUser == null) {
			throw new RuntimeException("User id not found: " + userId);
		}
		
		return theUser;
	}
	
	//adding mapping for POST /users - add new users
	@PostMapping("/")
	public User addUser(@RequestBody User theUser) {
		//also just in case they pass an id in json ..set id to 0
		//this is to force a save of a new item ... instead of update
		theUser.setId(0);
		userService.save(theUser);
		
		return theUser;
	}
	
	//consulting the user login
	@PostMapping("/login")
	public User validateUser(@RequestBody User theUser){
		Optional<User> user = userService.findByUsernameOrEmailAndPassword(
				theUser.getUsername(), theUser.getEmail(), theUser.getPassword());
		if(user.isEmpty()) {
			throw new RuntimeException("user not found");
		}
		
		User userTemp = new User();
		if(user.isPresent()) {	
			if(user.get().getPassword().equals(theUser.getPassword())) {
				userTemp.setId(user.get().getId());
				userTemp.setEmail(user.get().getEmail());
				userTemp.setUsername(user.get().getUsername());
			}
		}
		return userTemp;
	}

	
	// add mapping for updating users
	
	@PutMapping("/")
	public User updateUser(@RequestBody User theUser) {
		userService.save(theUser);
		return theUser;
	}
	
	@DeleteMapping("/")
	public String deleteUser(@RequestParam int userId) {
		
		User theUser = userService.findById(userId);
		
		//throw exception if null
		if(theUser == null) {
			throw new RuntimeException("User id not found - " + userId);
		}
		
		userService.deleteById(userId);
		return "Deleted user id - " + userId;
	}
}
