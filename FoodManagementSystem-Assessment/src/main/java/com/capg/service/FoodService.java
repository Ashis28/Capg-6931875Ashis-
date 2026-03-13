package com.capg.service;

import java.util.List;

import com.capg.entity.FoodItem;

public interface FoodService {
	
	public FoodItem addFoodItem(Long categoryId, String name, double price);
	
	public List<FoodItem> getItemsByCategory(Long categoryId);
	
	void removeFoodItem(Long itemId);
	
}
