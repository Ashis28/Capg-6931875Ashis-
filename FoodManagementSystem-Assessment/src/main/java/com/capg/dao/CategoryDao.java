package com.capg.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.entity.Category;


@Repository
public class CategoryDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		
		em.persist(category);
		
		return category;
	}

	public List<Category> getAllCategories() {
		
		String jpql = "SELECT c FROM Category c";

        return em.createQuery(jpql, Category.class)
                 .getResultList();
	}

	public Category findById(Long categoryId) {
	    return em.find(Category.class, categoryId);
	}

}
