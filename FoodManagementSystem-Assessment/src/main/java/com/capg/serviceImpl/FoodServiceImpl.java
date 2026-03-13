package com.capg.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.CategoryDao;
import com.capg.dao.FoodItemDao;
import com.capg.entity.Category;
import com.capg.entity.FoodItem;
import com.capg.service.FoodService;

@Service
@Transactional
public class FoodServiceImpl implements FoodService {

    private final FoodItemDao foodItemDao;
    private final CategoryDao categoryDao;

    @Autowired
    public FoodServiceImpl(FoodItemDao foodItemDao, CategoryDao categoryDao) {
        this.foodItemDao = foodItemDao;
        this.categoryDao = categoryDao;
    }

    @Override
    public FoodItem addFoodItem(Long categoryId, String name, double price) {

        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("Item name cannot be empty");
        }

        if(price <= 0) {
            throw new IllegalArgumentException("Price must be positive");
        }

        Category category = categoryDao.findById(categoryId);

        if(category == null) {
            throw new RuntimeException("Category not found");
        }

        FoodItem foodItem = new FoodItem();
        foodItem.setItemName(name);
        foodItem.setPrice(price);
        foodItem.setCategory(category);

        return foodItemDao.save(foodItem);
    }

    @Override
    public void removeFoodItem(Long itemId) {
        FoodItem item = foodItemDao.findById(itemId);

        if(item == null) {
            throw new RuntimeException("FoodItem not found");
        }

        foodItemDao.delete(item);
    }

	@Override
	public List<FoodItem> getItemsByCategory(Long categoryId) {

	    Category category = categoryDao.findById(categoryId);

	    if(category == null) {
	        throw new RuntimeException("Category not found");
	    }

	    return foodItemDao.findByCategory(categoryId);
	}

	
}