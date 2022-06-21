package com.cande.punkbar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.cande.punkbar.entity.OrderTest;

@Repository
public class OrderTestDaoImpl implements OrderTestDao {
	
	private EntityManager entityManager;
	
	public OrderTestDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<OrderTest> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<OrderTest> theQuery = currentSession.createQuery("from OrderTest", OrderTest.class);
		
		List<OrderTest> orders = theQuery.getResultList();
		
		return orders;
	}

	@Override
	public OrderTest findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		OrderTest order = currentSession.get(OrderTest.class, theId);
		
		return order;
	}

	@Override
	public void save(OrderTest theOrder) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theOrder);
	}

}
