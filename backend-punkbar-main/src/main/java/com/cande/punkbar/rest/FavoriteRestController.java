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
import com.cande.punkbar.dao.IFavoriteRepository;

@RestController
@RequestMapping("/favorites")
@CrossOrigin
public class FavoriteRestController {

	@Autowired
	private IFavoriteRepository favoriteService;
	
	@GetMapping("/{userId}")
	public List<Favorite> findAllByUserId(@PathVariable int userId) {
		return favoriteService.findAllByUserId(userId);
	}
	
	@PostMapping("/")
	public String addFavorite(@RequestBody Favorite theFavorite) {
		theFavorite.setId(0);
		Optional<Favorite> existingFavorite = favoriteService.findByProductNumberAndCategoryAndUserId(theFavorite.getProductNumber(), theFavorite.getCategory(), theFavorite.getUserId());
		
		if (existingFavorite.isEmpty()) {
			favoriteService.save(theFavorite);
		}
		return "favorite added";
	}
	
	@DeleteMapping("/{userId}")
	public String deleteFavorite(@RequestBody Favorite theFavorite, @PathVariable int userId) {
		theFavorite.setId(0);
		Optional<Favorite> existingFavorite = favoriteService.findByProductNumberAndCategoryAndUserId(theFavorite.getProductNumber(), theFavorite.getCategory(), userId);
		
		if (existingFavorite.isPresent()) {
			favoriteService.deleteById(existingFavorite.get().getId());
		}		
		return "favorite removed";
	}
	
	
}
