package com.cande.punkbar.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.Favorite;
import com.cande.punkbar.entity.User;
import com.cande.punkbar.service.FavoriteService;
import com.cande.punkbar.service.UserService;

@RestController
@RequestMapping("/favorites")
public class FavoriteRestController {

	private FavoriteService favoriteService;
	private UserService userService;
	
	@Autowired
	public FavoriteRestController(FavoriteService theFavoriteService, UserService theUserService) {
		favoriteService = theFavoriteService;
		userService = theUserService;
	}
	
	@GetMapping("/")
	@CrossOrigin
	public List<Favorite> findAllByUserId(@RequestParam int userId) {
		return favoriteService.findAllByUserId(userId);
	}
	
	/*@GetMapping("/{favoriteId}")
	@CrossOrigin
	public Favorite getFavorite(@PathVariable int favoriteId) {
		Favorite theFavorite = favoriteService.findById(favoriteId);
		
		if(theFavorite == null) {
			throw new RuntimeException("Favorite id not found - " + favoriteId);
		}
		
		return theFavorite;
	}*/
	
	@PostMapping("/")
	@CrossOrigin
	public String addFavorite(@RequestBody Favorite theFavorite) {
		theFavorite.setId(0);
		Optional<Favorite> existingFavorite = favoriteService.findByProductNumberAndCategoryAndUserId(theFavorite.getProductNumber(), theFavorite.getCategory(), theFavorite.getUserId());
		
		if (existingFavorite.isEmpty()) {
			favoriteService.save(theFavorite);
		}
		
		return "favorite added";
		
		/*else {
			favoriteService.deleteById(existingFavorite.get().getId());
			return "favorite removed";
		}*/
		
	}
	
	/*@DeleteMapping("/users/{userId}/favorite/{favoriteId}")
	@CrossOrigin
	public String deleteFavorite(@RequestParam int userId, @RequestParam int productNumber) {
		Favorite theFavorite = favoriteService.;
		User theUser = userService.findById(userId);
		if(theFavorite == null) {
			throw new RuntimeException("Favorite not found " + favoriteId);
		}
		
		favoriteService.deleteById(favoriteId);
		
		return "Favorite (id: " + favoriteId + ") deleted! user: " + theUser.getUsername() + " " + userId;
	}*/
	
	@DeleteMapping("/")
	@CrossOrigin
	public String deleteFavorite(@RequestBody Favorite theFavorite) {
		theFavorite.setId(0);
		Optional<Favorite> existingFavorite = favoriteService.findByProductNumberAndCategoryAndUserId(theFavorite.getProductNumber(), theFavorite.getCategory(), theFavorite.getUserId());
		
		if (existingFavorite.isPresent()) {
			favoriteService.deleteById(existingFavorite.get().getId());
		}		
		return "favorite removed";
	}
	
	
}
