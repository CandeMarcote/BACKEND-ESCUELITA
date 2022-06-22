package com.cande.punkbar.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.Favorite;

public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {

}
