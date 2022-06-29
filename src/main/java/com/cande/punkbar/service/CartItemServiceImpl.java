package com.cande.punkbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.CartItemRepository;
import com.cande.punkbar.entity.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {
	
	private CartItemRepository cartItemRepository;
	
	@Autowired
	public CartItemServiceImpl(CartItemRepository theCartItemRepository) {
		cartItemRepository = theCartItemRepository;
	}

	@Override
	public void save(CartItem theCartItem) {
		theCartItem.setId(0);
		cartItemRepository.save(theCartItem);
	}

	@Override
	public void deleteById(int theId) {
		cartItemRepository.deleteById(theId);
		
	}

	@Override
	public void deleteAll() {
		cartItemRepository.deleteAll();		
	}

	@Override
	public List<CartItem> findAllByUserId(int userId) {
		List<CartItem> theCartItems = cartItemRepository.findAllByUserId(userId);
		return theCartItems;
	}

	@Override
	public CartItem findByUserIdAndProductNumberAndCategory(int userId, int theProductNumber,
			String theCategory) {
		CartItem theCartItem = cartItemRepository.findByUserIdAndProductNumberAndCategory(userId, theProductNumber, theCategory);
		return theCartItem;
	}



}
