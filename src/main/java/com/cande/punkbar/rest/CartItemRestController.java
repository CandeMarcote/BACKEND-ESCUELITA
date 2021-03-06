package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.service.CartItemService;

@RestController
@RequestMapping("/cartItems")
public class CartItemRestController {

	private CartItemService cartItemService;
	
	public CartItemRestController (CartItemService theCartItemService) {
		cartItemService = theCartItemService;
	}
	
	@GetMapping("/all")
	@CrossOrigin
	public List<CartItem> findAllByUserId(@RequestParam int userId) {
		List<CartItem> theCartItems = cartItemService.findAllByUserId(userId);
		return theCartItems;
	}
	
	
	@PostMapping("/{userId}")
	@CrossOrigin
	public CartItem addCartItem(@RequestBody CartItem theCartItem, @PathVariable int userId) {
		
		theCartItem.setId(0);
		theCartItem.setUserId(userId);
		cartItemService.save(theCartItem);
		return theCartItem;
	}
	
	@DeleteMapping("/{userId}")
	@CrossOrigin
	public String deleteCartItem(@RequestBody CartItem theCartItem, @PathVariable int userId) {
		
		CartItem existingItem = cartItemService.findByUserIdAndProductNumberAndCategory(userId, theCartItem.getProductNumber(), theCartItem.getCategory());
		cartItemService.deleteById(existingItem.getId());
		return "deleted";
	}
	
	@DeleteMapping("/deleteAll")
	@CrossOrigin
	public String deleteAll() {
		cartItemService.deleteAll();
		return "the cart is empty";
	}
	
	@PutMapping("/{userId}")
	@CrossOrigin
	public CartItem updateItem(@RequestBody CartItem theCartItem, @PathVariable int userId) {
		CartItem existingItem = cartItemService.findByUserIdAndProductNumberAndCategory(
				userId, theCartItem.getProductNumber(), theCartItem.getCategory());
		existingItem.setAmount(theCartItem.getAmount());
		cartItemService.deleteById(existingItem.getId());
		cartItemService.save(existingItem);
		return existingItem;
	}
}