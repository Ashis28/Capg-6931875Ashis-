package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.entity.Category;
import com.capg.entity.FoodItem;


@Repository
public class FoodItemDao {

	@PersistenceContext
	private EntityManager em;
	
	public FoodItem findById(Long itemId) {
		
		return em.find(FoodItem.class, itemId);
	}

	public FoodItem save(FoodItem foodItem) {
		em.persist(foodItem);
		return foodItem;
	}

	public void delete(FoodItem item) {
		// TODO Auto-generated method stub
		
		if(!em.contains(item)) {
	        item = em.merge(item);
	    }

	    em.remove(item);
		
	}

	public List<FoodItem> findByCategory(Long categoryId) {
		
		String jpql = "SELECT f FROM FoodItem f WHERE f.category.id = :id";

	    return em.createQuery(jpql, FoodItem.class)
	             .setParameter("id", categoryId)
	             .getResultList();
	}

}
