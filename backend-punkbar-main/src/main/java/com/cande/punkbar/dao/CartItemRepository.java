package com.cande.punkbar.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cande.punkbar.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

	public CartItem findByUserIdAndProductNumberAndCategory(int userId, int theProductNumber, String theCategory);
	
	public List<CartItem> findAllByUserId(int theUserId);
}