package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.FavoriteRepository;
import com.cande.punkbar.entity.Favorite;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteRepository favoriteRepository;
	
	@Autowired
	public FavoriteServiceImpl(FavoriteRepository theFavoriteRepository) {
		favoriteRepository = theFavoriteRepository;
	}
	
	@Override
	public List<Favorite> findAll() {
		return favoriteRepository.findAll();
	}

	@Override
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

	@Override
	public void save(Favorite theFavorite) {
		favoriteRepository.save(theFavorite);
	}

	@Override
	public void deleteById(int theId) {
		favoriteRepository.deleteById(theId);
	}

}
