package com.capg.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.order.entities.Order;
import com.capg.order.entities.OrderDTO;
import com.capg.order.service.OrderService;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	private OrderService service;
	
	@PostMapping("/addorder")
	public Order addOrder(@RequestBody OrderDTO order) {
		return service.addOrder(order);
	}
	
	@GetMapping("/getallorder")
	public List<Order> getAllOrder(){
		return service.getAllOrders();
	}
	
	@GetMapping("/getorder/{id}")
	public Order getOrderById(@PathVariable long id) {
		return service.getOrderById(id);
	}
	
	@PutMapping("/updateorder/{id}")
	public Order updateOrder(@PathVariable long id,@RequestBody OrderDTO order) {
		return service.updateOrder(id, order);
	}
	
	@DeleteMapping("/deleteorder/{id}")
	public String deleteOrder(long id) {
		service.deleteOrder(id);
		return "Order Deleted Successfully!!!";
		
	}
	
}
