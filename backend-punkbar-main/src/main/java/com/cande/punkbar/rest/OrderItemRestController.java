package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@PostMapping("/place_order")
	@CrossOrigin
	public String addOrderItem(@RequestParam int userId) {
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
