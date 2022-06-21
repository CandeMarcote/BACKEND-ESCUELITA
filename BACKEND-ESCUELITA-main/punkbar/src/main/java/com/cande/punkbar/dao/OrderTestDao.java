package com.cande.punkbar.dao;

import java.util.List;

import com.cande.punkbar.entity.OrderTest;

public interface OrderTestDao {

	public List<OrderTest> findAll();
	
	public OrderTest findById(int theId);
	
	public void save(OrderTest theOrder);
}
