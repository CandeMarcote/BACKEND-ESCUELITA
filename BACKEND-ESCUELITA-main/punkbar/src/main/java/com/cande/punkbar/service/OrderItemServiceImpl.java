package com.cande.punkbar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cande.punkbar.dao.CartItemDAO;
import com.cande.punkbar.dao.OrderItemDAO;
import com.cande.punkbar.entity.OrderItem;

@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	private OrderItemDAO orderItemDao;
	
	public OrderItemServiceImpl (OrderItemDAO theOrderItemDao) {
		orderItemDao = theOrderItemDao;
	}
	
	

	@Override
	public List<OrderItem> findAll() {
		return orderItemDao.findAll();
	}

	@Override
	public OrderItem findById(int theId) {
		return orderItemDao.findById(theId);
	}

	@Override
	public void save(OrderItem theOrderItem) {
		orderItemDao.save(theOrderItem);
	}

	@Override
	public void deleteById(int theId) {
		orderItemDao.deleteById(theId);
	}

}
