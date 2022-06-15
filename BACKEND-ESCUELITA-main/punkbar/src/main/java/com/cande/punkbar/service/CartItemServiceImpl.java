package com.cande.punkbar.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.CartItemDAO;
import com.cande.punkbar.entity.CartItem;

@Service
public class CartItemServiceImpl implements CartItemService {

	private CartItemDAO cartItemDao;
	
	public CartItemServiceImpl(CartItemDAO theCartItemDao) {
		cartItemDao = theCartItemDao;
	}
	
	@Override
	@Transactional
	public List<CartItem> findAll() {
		return cartItemDao.findAll();
	}

	@Override
	@Transactional
	public CartItem findById(int theId) {
		return cartItemDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(CartItem theCartItem) {
		cartItemDao.save(theCartItem);
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		cartItemDao.deleteById(theId);
	}

}
