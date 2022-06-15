package com.cande.punkbar.dao;

import java.util.List;

import com.cande.punkbar.entity.Favorite;

public interface FavoriteDAO {
	
	public List<Favorite> findAll();
	
	public Favorite findById(int theId);
	
	public void save (Favorite theFavorite);
	
	public void deleteById(int theId);
}
