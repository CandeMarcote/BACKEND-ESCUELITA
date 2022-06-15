package com.cande.punkbar.dao;

import java.util.List;

import com.cande.punkbar.entity.OrderItem;

public interface OrderItemDAO {

	public List<OrderItem> findAll();
	
	public OrderItem findById(int theId);
	
	public void save(OrderItem theOrderItem);
	
	public void deleteById(int theId);
}
