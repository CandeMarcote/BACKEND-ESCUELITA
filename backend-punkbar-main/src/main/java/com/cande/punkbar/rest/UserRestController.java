package com.cande.punkbar.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.User;
import com.cande.punkbar.dao.IUserRespository;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserRestController {

	@Autowired
	private IUserRespository userService;
	
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
	//que devuelva todo y yo elija el id desde el front
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

}
