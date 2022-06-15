package com.cande.punkbar.dao;

import java.util.List;

import com.cande.punkbar.entity.CartItem;

public interface CartItemDAO {

	public List<CartItem> findAll();
	
	public CartItem findById(int theId);
	
	public void save(CartItem theCartItem);
	
	public void deleteById(int theId);
}
