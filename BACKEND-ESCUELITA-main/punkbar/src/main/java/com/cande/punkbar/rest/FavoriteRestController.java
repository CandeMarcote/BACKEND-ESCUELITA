package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.Favorite;
import com.cande.punkbar.entity.User;
import com.cande.punkbar.service.FavoriteService;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/api")
public class FavoriteRestController {

	private FavoriteService favoriteService;
	private UserService userService;
	
	@Autowired
	public FavoriteRestController(FavoriteService theFavoriteService, UserService theUserService) {
		favoriteService = theFavoriteService;
		userService = theUserService;
	}
	
	@GetMapping("/favorites")
	public List<Favorite> findAll() {
		return favoriteService.findAll();
	}
	
	@GetMapping("/favorites/{favoriteId}")
	public Favorite getFavorite(@PathVariable int favoriteId) {
		Favorite theFavorite = favoriteService.findById(favoriteId);
		
		if(theFavorite == null) {
			throw new RuntimeException("Favorite id not found - " + favoriteId);
		}
		
		return theFavorite;
	}
	
	@PostMapping("/favorites")
	public Favorite addFavorite(@RequestBody Favorite theFavorite) {
		//theFavorite.setId(0);
		favoriteService.save(theFavorite);
		return theFavorite;
	}
	
	@DeleteMapping("/users/{userId}/favorites/{favoriteId}")
	public String deleteFavorite(@PathVariable int favoriteId, @PathVariable int userId) {
		Favorite theFavorite = favoriteService.findById(favoriteId);
		User theUser = userService.findById(userId);
		if(theFavorite == null) {
			throw new RuntimeException("Favorite not found " + favoriteId);
		}
		
		favoriteService.deleteById(favoriteId);
		
		return "Favorite (id: " + favoriteId + ") deleted! user: " + userId;
	}
}