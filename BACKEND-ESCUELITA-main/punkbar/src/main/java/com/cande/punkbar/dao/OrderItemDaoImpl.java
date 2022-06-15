package com.cande.punkbar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.entity.CartItem;
import com.cande.punkbar.entity.OrderItem;

@Repository
public class OrderItemDaoImpl implements OrderItemDAO {

	private EntityManager entityManager;
	
	@Autowired
	public OrderItemDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<OrderItem> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<OrderItem> theQuery = currentSession.createQuery("from OrderItem", OrderItem.class);
		
		List<OrderItem> order = theQuery.getResultList();
		
		return order;
	}

	@Override
	public OrderItem findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		OrderItem theOrderItem = currentSession.get(OrderItem.class, theId);
		
		return theOrderItem;
	}

	@Override
	public void save(OrderItem theOrderItem) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theOrderItem);
		
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery =
				currentSession.createQuery("delete from OrderItem where id=:orderItemId");
		theQuery.setParameter("orderItemId", theId);
		
		theQuery.executeUpdate();
		
	}
	
	

}
