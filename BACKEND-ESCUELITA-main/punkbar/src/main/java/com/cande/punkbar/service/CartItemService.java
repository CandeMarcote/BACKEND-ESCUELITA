package com.cande.punkbar.service;

import java.util.List;

import com.cande.punkbar.entity.CartItem;

public interface CartItemService {

	public List<CartItem> findAll();
	
	public CartItem findById(int theId);
	
	public void save(CartItem theCartItem);
	
	public void deleteById(int theId);
}
