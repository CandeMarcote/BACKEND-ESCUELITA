package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import com.cande.punkbar.entity.OrderItem;

public interface OrderItemService {

	public List<OrderItem> findAll();
	
	public Optional<OrderItem> findById(int theId);
	
	public void save(OrderItem theOrderItem);
	
	public void deleteById(int theId);
	
	public void deleteAll();
}
