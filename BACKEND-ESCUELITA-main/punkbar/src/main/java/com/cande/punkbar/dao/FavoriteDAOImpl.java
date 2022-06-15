package com.cande.punkbar.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cande.punkbar.entity.Favorite;

@Repository
public class FavoriteDAOImpl implements FavoriteDAO {
	
	//define field for EntityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public FavoriteDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Favorite> findAll() {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Favorite> theQuery =
				currentSession.createQuery("from Favorite", Favorite.class);
		
		List<Favorite> favorites = theQuery.getResultList();
		
		return favorites;
	}

	@Override
	public Favorite findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Favorite theFavorite =
				currentSession.get(Favorite.class, theId);
		
		return theFavorite;
	}

	@Override
	public void save(Favorite theFavorite) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		currentSession.saveOrUpdate(theFavorite);
	}

	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery =
				currentSession.createQuery(
						"delete from Favorite where id=:favoriteId");
		theQuery.setParameter("favoriteId", theId);
		
		theQuery.executeUpdate();
	}

}
