package com.cande.punkbar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.dao.OrderTestDao;
import com.cande.punkbar.entity.OrderTest;

@Service
public class OrderTestServiceImpl implements OrderTestService {

	private OrderTestDao orderTestDao;
	
	@Autowired
	public OrderTestServiceImpl(OrderTestDao theOrderTestDao) {
		orderTestDao = theOrderTestDao;
	}
	
	@Override
	@Transactional
	public List<OrderTest> findAll() {
		return orderTestDao.findAll();
	}

	@Override
	@Transactional
	public OrderTest findById(int theId) {
		return orderTestDao.findById(theId);
	}

	@Override
	@Transactional
	public void save(OrderTest theOrderTest) {
		orderTestDao.save(theOrderTest);
	}
}
