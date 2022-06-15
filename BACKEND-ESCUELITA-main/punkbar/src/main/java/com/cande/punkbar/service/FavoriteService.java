package com.cande.punkbar.service;

import java.util.List;

import com.cande.punkbar.entity.Favorite;

public interface FavoriteService {

	public List<Favorite> findAll();
	
	public Favorite findById(int theId);
	
	public void save(Favorite theFavorite);
	
	public void deleteById(int theId);
}
