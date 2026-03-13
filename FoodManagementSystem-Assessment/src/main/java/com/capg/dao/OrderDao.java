package com.capg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.capg.entity.Order;

@Repository
public class OrderDao {

    @PersistenceContext
    private EntityManager em;

    public Order save(Order order) {
        em.persist(order);
        return order;
    }

    public Order findById(Long orderId) {
        return em.find(Order.class, orderId);
    }
}