package com.cande.punkbar.service;

import java.util.List;

import com.cande.punkbar.entity.OrderTest;

public interface OrderTestService {

	public List<OrderTest> findAll();
	
	public OrderTest findById(int theId);
	
	public void save(OrderTest theOrderTest);
}
