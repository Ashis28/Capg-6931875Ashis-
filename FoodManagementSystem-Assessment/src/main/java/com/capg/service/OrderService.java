package com.capg.service;

import java.util.List;

import com.capg.entity.Order;

public interface OrderService {
	
	Order placeOrder(List<Long> foodItemIds, String customerName);

    double calculateTotal(Long orderId);
}
