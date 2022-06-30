package com.cande.punkbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.ICartItemRepository;
import com.cande.punkbar.entity.CartItem;

@Service
public class CartItemService {
	
	@Autowired
	private ICartItemRepository cartItemRepository;

	public void save(CartItem theCartItem) {
		theCartItem.setId(0);
		cartItemRepository.save(theCartItem);
	}

	public void deleteById(int theId) {
		cartItemRepository.deleteById(theId);
		
	}
	
	public void deleteAllByUserId(int userId) {
		cartItemRepository.deleteAllByUserId(userId);		
	}

	public List<CartItem> findAllByUserId(int theUserId) {
		List<CartItem> theCartItems = cartItemRepository.findAllByUserId(theUserId);
		return theCartItems;
	}

	public CartItem findByUserIdAndProductNumberAndCategory(int userId, int theProductNumber,
			String theCategory) {
		CartItem theCartItem = cartItemRepository.findByUserIdAndProductNumberAndCategory(userId, theProductNumber, theCategory);
		return theCartItem;
	}
}
