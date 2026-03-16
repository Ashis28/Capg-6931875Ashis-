package com.capg.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.order.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long>{
	
	public Order findById(long id);
	
	public void deleteById(long id);
}
