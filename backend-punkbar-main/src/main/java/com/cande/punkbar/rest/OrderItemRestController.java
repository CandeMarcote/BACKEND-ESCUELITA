package com.cande.punkbar.rest;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.dao.ICartItemRepository;
import com.cande.punkbar.dao.IOrderItemRepository;
import com.cande.punkbar.dao.IOrderRepository;
import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.entity.Order;
import com.cande.punkbar.entity.OrderItem;

@RestController
@RequestMapping("/orderItems")
public class OrderItemRestController {

	@Autowired
	private IOrderItemRepository orderItemService;
	@Autowired
	private ICartItemRepository cartItemService;
	@Autowired
	private IOrderRepository orderService;
	
	@PostMapping("/place_order/{userId}")
	@CrossOrigin
	public List<CartItem> addOrderItem(@PathVariable int userId) {
		Calendar calendar = new GregorianCalendar();
		Order theOrder = new Order();
		theOrder.setUserId(userId);
		theOrder.setOrderNumber(calendar.getTimeInMillis());
		orderService.save(theOrder);
		
		List<CartItem> cartItems = cartItemService.findAllByUserId(userId);
		
		for (CartItem cartItem : cartItems) {
			OrderItem theOrderItem = new OrderItem();
			theOrderItem.setAmount(cartItem.getAmount());
			theOrderItem.setCategory(cartItem.getCategory());
			theOrderItem.setProductNumber(cartItem.getProductNumber());
			theOrderItem.setOrderId(theOrder.getId());
			orderItemService.save(theOrderItem);
		}
		
		
		return cartItems;
	}
}
