package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.IOrderItemRepository;
import com.cande.punkbar.entity.OrderItem;

@Service
public class OrderItemService {

	@Autowired
	private IOrderItemRepository orderItemRepository;
	
	public List<OrderItem> findAll() {
		List<OrderItem> theOrderItems = orderItemRepository.findAll();
		return theOrderItems;
	}

	public Optional<OrderItem> findById(int theId) {
		Optional<OrderItem> theOrderItem = orderItemRepository.findById(theId);
		
		if (theOrderItem.isEmpty()) {
			throw new RuntimeException ("order not found");
		}
		
		return theOrderItem;
	}

	public void save(OrderItem theOrderItem) {
		orderItemRepository.save(theOrderItem);

	}

	public void deleteById(int theId) {
		orderItemRepository.deleteById(theId);
	}

	public void deleteAll() {
		orderItemRepository.deleteAll();
	}

}
