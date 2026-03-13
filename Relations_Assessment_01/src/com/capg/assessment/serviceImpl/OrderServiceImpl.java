package com.capg.assessment.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.capg.assessment.entities.Customer;
import com.capg.assessment.entities.Order;
import com.capg.assessment.entities.Product;
import com.capg.assessment.services.OrderService;

public class OrderServiceImpl implements OrderService {
    private EntityManager em;

    public OrderServiceImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Order placeOrder(Long customerId, List<Long> productIds) {
        em.getTransaction().begin();
        Customer customer = em.find(Customer.class, customerId);

        Order order = new Order();
        order.setCustomer(customer);
        order.setOrderDate("2026-02-22");
        order.setTotalAmount(0.0);

        List<Product> products = new ArrayList<>();
        for (Long pid : productIds) {
            Product product = em.find(Product.class, pid);
            products.add(product);
            order.setTotalAmount(order.getTotalAmount() + product.getPrice());
        }
        order.setProducts(products);

        em.persist(order);
        em.getTransaction().commit();
        return order;
    }
}
