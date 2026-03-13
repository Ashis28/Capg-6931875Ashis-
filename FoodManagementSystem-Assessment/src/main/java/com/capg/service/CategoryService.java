package com.capg.service;

import java.util.List;

import com.capg.entity.Category;

public interface CategoryService {
	
	Category  addCategory(String name, String description);

	List<Category> getAllCategories();
	
	Category findById(Long CategoryId);
}
