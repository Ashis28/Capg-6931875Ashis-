package com.capg.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.CategoryDao;
import com.capg.entity.Category;
import com.capg.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public Category addCategory(String name, String description) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Category name cannot be empty");
        }

        Category category = new Category();
        category.setCategoryName(name);
        category.setDescription(description);

        return categoryDao.addCategory(category);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.getAllCategories();
    }

	@Override
	public Category findById(Long CategoryId) {
		return categoryDao.findById(CategoryId);
	}
}
