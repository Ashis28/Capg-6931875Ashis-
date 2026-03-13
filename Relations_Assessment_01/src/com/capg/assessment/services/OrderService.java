package com.capg.assessment.services;

import java.util.List;

import com.capg.assessment.entities.Order;

public interface OrderService {
	Order placeOrder(Long customerId, List<Long> productIds);

}
