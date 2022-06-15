package com.cande.punkbar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cande.punkbar.entity.CartItem;

@Repository
public class CartItemDaoImpl implements CartItemDAO {

	private EntityManager entityManager;
	
	@Autowired
	public CartItemDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<CartItem> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<CartItem> theQuery = currentSession.createQuery("from CartItem", CartItem.class);
		
		List<CartItem> cart = theQuery.getResultList();
		
		return cart;
		
	}

	@Override
	public CartItem findById(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		CartItem theCartItem = 
				currentSession.get(CartItem.class, theId);
		
		return theCartItem;
	}

	@Override
	public void save(CartItem theCartItem) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theCartItem);
		
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query theQuery = currentSession.createQuery("delete from CartItem where id=:cartItemId");
		theQuery.setParameter("cardItemId", theId);
		
		theQuery.executeUpdate();
		
	}

}
