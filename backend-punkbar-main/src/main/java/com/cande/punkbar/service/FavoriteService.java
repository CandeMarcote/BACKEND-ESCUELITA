package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.IFavoriteRepository;
import com.cande.punkbar.entity.Favorite;

@Service
public class FavoriteService {

	@Autowired
	private IFavoriteRepository favoriteRepository;
	
	public List<Favorite> findAllByUserId(int userId) {
		return favoriteRepository.findAllByUserId(userId);
	}

	public Favorite findById(int theId) {
		Optional<Favorite> result = favoriteRepository.findById(theId);
		
		Favorite theFavorite = null;
		if(result.isPresent()) {
			theFavorite = result.get();
		}
		else {
			throw new RuntimeException("The favorite id was not found");
		}
		
		return theFavorite;
	}

	public void save(Favorite theFavorite) {
		favoriteRepository.save(theFavorite);
	}
	
	public void deleteById(int theId) {
		favoriteRepository.deleteById(theId);
	}
	
	public void deleteAllById(int userId) {
		favoriteRepository.deleteAllById(userId);
	}

	public Optional<Favorite> findByProductNumberAndCategoryAndUserId(int theProductNumber, String theCategory, int userId) {
		Optional<Favorite> theFavorite = favoriteRepository.findByProductNumberAndCategoryAndUserId(theProductNumber, theCategory, userId);
		return theFavorite;
	}

}
