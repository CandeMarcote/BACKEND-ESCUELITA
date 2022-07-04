package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.dao.ICartItemRepository;
import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.entity.OrderItem;

@RestController
@RequestMapping("/cartItems")
public class CartItemRestController {

	@Autowired
	private ICartItemRepository cartItemService;
	
	@GetMapping("/{userId}/all")
	@CrossOrigin
	public List<CartItem> findAllByUserId(@PathVariable int userId) {
		List<CartItem> theCartItems = cartItemService.findAllByUserId(userId);
		return theCartItems;
	}
	
	
	@PostMapping("/{userId}")
	@CrossOrigin
	public CartItem addCartItem(@RequestBody CartItem theCartItem, @PathVariable int userId) {
		List<CartItem> cartItems = cartItemService.findAllByUserId(userId);
		
		//update amount
		for(CartItem cartItem : cartItems) {
			if((theCartItem.getProductNumber() == cartItem.getProductNumber()) && theCartItem.getCategory().equals(cartItem.getCategory())) {
				cartItem.setAmount(theCartItem.getAmount());
				cartItemService.deleteById(cartItem.getId());
			}
		}
		
		//delete product if amount is lower than 0
		if(theCartItem.getAmount() > 0) {
			theCartItem.setId(0);
			theCartItem.setUserId(userId);
			cartItemService.save(theCartItem);
		}
		
		return theCartItem;
	}
	
	@DeleteMapping("/{userId}")
	@CrossOrigin
	public String deleteCartItem(@RequestBody CartItem theCartItem, @PathVariable int userId) {
		
		CartItem existingItem = cartItemService.findByUserIdAndProductNumberAndCategory(userId, theCartItem.getProductNumber(), theCartItem.getCategory());
		cartItemService.deleteById(existingItem.getId());
		return "deleted";
	}
	
	@DeleteMapping("/deleteAll/{userId}")
	@CrossOrigin
	public String deleteAllByUserId(@PathVariable int userId) {
		
		List<CartItem> theCartItems = cartItemService.findAllByUserId(userId);
		for(int i = 0; i < theCartItems.size(); i++) {
			cartItemService.delete(theCartItems.get(i));
		}
		return "all deleted";
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
