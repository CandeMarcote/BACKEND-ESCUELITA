package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.entity.Order;
import com.cande.punkbar.entity.OrderItem;
import com.cande.punkbar.service.CartItemService;
import com.cande.punkbar.service.OrderItemService;
import com.cande.punkbar.service.OrderService;

@RestController
@RequestMapping("/orderItems")
public class OrderItemRestController {

	private OrderItemService orderItemService;
	private CartItemService cartItemService;
	private OrderService orderService;
	
	public OrderItemRestController(OrderItemService theOrderItemService, OrderService theOrderService, CartItemService theCartItemService) {
		orderItemService = theOrderItemService;
		cartItemService = theCartItemService;
		orderService = theOrderService;
	}
	
	@PostMapping("/place_order/{userId}")
	@CrossOrigin
	public String addOrderItem(@PathVariable int userId) {
		Order theOrder = new Order();
		theOrder.setUserId(userId);
		orderService.save(theOrder);
		
		
		List<CartItem> cartItems = cartItemService.findAllByUserId(userId);
		
		for(int i = 0; i < cartItems.size(); i++) {
			OrderItem theOrderItem = new OrderItem();
			theOrderItem.setAmount(cartItems.get(i).getAmount());
			theOrderItem.setCategory(cartItems.get(i).getCategory());
			theOrderItem.setProductNumber(cartItems.get(i).getProductNumber());
			theOrderItem.setOrderId(theOrder.getId());
			orderItemService.save(theOrderItem);
		}
		
		
		return "added sucessfully";
	}
}
