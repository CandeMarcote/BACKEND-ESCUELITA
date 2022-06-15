package com.cande.punkbar.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cande.punkbar.dao.OrderItemDAO;
import com.cande.punkbar.entity.OrderItem;

@RestController
@RequestMapping("/api")
public class OrderItemRestController {

	private OrderItemDAO orderItemDao;
	
	@Autowired
	public OrderItemRestController (OrderItemDAO theOrderItemDao) {
		orderItemDao = theOrderItemDao;
	}
	
	@GetMapping("/order")
	public List<OrderItem> findAll(){
		return orderItemDao.findAll();
	}
}
