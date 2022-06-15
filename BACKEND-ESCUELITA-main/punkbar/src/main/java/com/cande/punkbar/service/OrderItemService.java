package com.cande.punkbar.service;

import java.util.List;

import com.cande.punkbar.entity.OrderItem;

public interface OrderItemService {

	public List<OrderItem> findAll();
	
	public OrderItem findById(int theId);
	
	public void save (OrderItem theOrderItem);
	
	public void deleteById(int theId);
}
