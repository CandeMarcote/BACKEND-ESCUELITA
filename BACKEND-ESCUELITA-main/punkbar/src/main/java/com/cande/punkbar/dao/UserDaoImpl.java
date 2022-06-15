package com.cande.punkbar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cande.punkbar.entity.User;

@Repository
public class UserDaoImpl implements UserDAO{

	//define field for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public UserDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	//@Transactional: we create a service to use it many times
	public List<User> findAll() {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a query
		Query<User> theQuery =
				currentSession.createQuery("from User", User.class);
		
		//execute query and get result list
		List<User> users = theQuery.getResultList();
		
		//return the results
		return users;
	}

	@Override
	public User findById(int theId) {
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get the user
		User theUser =
				currentSession.get(User.class, theId);
		
		//return the user
		return theUser;
	}

	@Override
	public void save(User theUser) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save user
		currentSession.saveOrUpdate(theUser);
	}

	@Override
	public void deleteById(int theId) {
		
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with primary key
		Query theQuery = currentSession.createQuery(
				"delete from User where id=:userId");
		
		theQuery.setParameter("userId", theId);
		
		theQuery.executeUpdate();
	}
}
