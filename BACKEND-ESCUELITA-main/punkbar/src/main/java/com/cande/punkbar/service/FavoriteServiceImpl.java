package com.cande.punkbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.FavoriteDAO;
import com.cande.punkbar.entity.Favorite;

@Service
public class FavoriteServiceImpl implements FavoriteService {

	private FavoriteDAO favoriteDao;
	
	@Autowired
	public FavoriteServiceImpl(FavoriteDAO theFavoriteDao) {
		favoriteDao = theFavoriteDao;
	}
	
	@Override
	@Transactional
	public List<Favorite> findAll() {
		return favoriteDao.findAll();
	}

	@Override
	@Transactional
	public Favorite findById(int theId) {
		return favoriteDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(Favorite theFavorite) {
		favoriteDao.save(theFavorite);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		favoriteDao.deleteById(theId);
	}

}
