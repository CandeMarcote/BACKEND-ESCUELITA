package com.cande.punkbar.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.Favorite;

public interface IFavoriteRepository extends JpaRepository<Favorite, Integer> {

	public Optional<Favorite> findByProductNumberAndCategoryAndUserId(int theProductNumber, String theCategory, int theUserId);
	
	public List<Favorite> findAllByUserId(int theUserId);
}
