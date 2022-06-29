package com.cande.punkbar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.OrderItemRepository;
import com.cande.punkbar.entity.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {

	private OrderItemRepository orderItemRepository;
	
	@Autowired
	public OrderItemServiceImpl(OrderItemRepository theOrderItemRepository) {
		orderItemRepository = theOrderItemRepository;
	}
	
	
	@Override
	public List<OrderItem> findAll() {
		List<OrderItem> theOrderItems = orderItemRepository.findAll();
		return theOrderItems;
	}

	@Override
	public Optional<OrderItem> findById(int theId) {
		Optional<OrderItem> theOrderItem = orderItemRepository.findById(theId);
		
		if (theOrderItem.isEmpty()) {
			throw new RuntimeException ("order not found");
		}
		
		return theOrderItem;
	}

	@Override
	public void save(OrderItem theOrderItem) {
		orderItemRepository.save(theOrderItem);

	}

	@Override
	public void deleteById(int theId) {
		orderItemRepository.deleteById(theId);
	}

	@Override
	public void deleteAll() {
		orderItemRepository.deleteAll();
	}

}
