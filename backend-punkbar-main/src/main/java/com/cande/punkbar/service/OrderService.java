package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.IOrderRepository;
import com.cande.punkbar.entity.Order;

@Service
public class OrderService {

	@Autowired
	private IOrderRepository orderRepository;
	
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	public Order findById(int theId) {
		Optional<Order> result = orderRepository.findById(theId);
		
		Order theOrder = null;
		if(result.isPresent()) {
			theOrder = result.get();
		}
		else {
			throw new RuntimeException("The order id was not found");
		}
		
		return theOrder;
	}

	public void save(Order theOrder) {
		orderRepository.save(theOrder);
	}

	public void deleteById(int theId) {
		orderRepository.deleteById(theId);
	}

}