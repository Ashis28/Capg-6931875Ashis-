package com.capg.serviceImpl;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.FoodItemDao;
import com.capg.dao.OrderDao;
import com.capg.entity.FoodItem;
import com.capg.entity.Order;
import com.capg.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderDao orderDao;
    private final FoodItemDao foodItemDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao, FoodItemDao foodItemDao) {
        this.orderDao = orderDao;
        this.foodItemDao = foodItemDao;
    }

    @Override
    public Order placeOrder(List<Long> foodItemIds, String customerName) {

        if(customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException("Customer name cannot be empty");
        }

        if(foodItemIds == null || foodItemIds.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }

        Order order = new Order();
        order.setCustomerName(customerName);
        order.setOrderDate(LocalDateTime.now());

        List<FoodItem> items = foodItemIds.stream()
                .map(id -> {
                    FoodItem item = foodItemDao.findById(id);
                    if(item == null) {
                        throw new RuntimeException("FoodItem not found: " + id);
                    }
                    return item;
                })
                .toList();

        order.setFoodItems(items);

        double total = items.stream()
                .mapToDouble(FoodItem::getPrice)
                .sum();

        order.setTotalAmount(total);

        return orderDao.save(order);
    }

    @Override
    public double calculateTotal(Long orderId) {

        Order order = orderDao.findById(orderId);

        if(order == null) {
            throw new RuntimeException("Order not found");
        }

        return order.getFoodItems()
                    .stream()
                    .mapToDouble(FoodItem::getPrice)
                    .sum();
    }
}