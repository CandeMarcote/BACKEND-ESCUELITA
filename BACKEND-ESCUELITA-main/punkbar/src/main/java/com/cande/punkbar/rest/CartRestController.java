package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.dao.CartItemDAO;
import com.cande.punkbar.entity.CartItem;

@RestController
@RequestMapping("/api")
public class CartRestController {

	private CartItemDAO cartItemDao;
	
	@Autowired
	public CartRestController(CartItemDAO theCartItemDao) {
		cartItemDao = theCartItemDao;
	}
	
	@GetMapping("/cart")
	public List<CartItem> findAll() {
		return cartItemDao.findAll();
	}
}
