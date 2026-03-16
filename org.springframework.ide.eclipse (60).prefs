package com.capg.order.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capg.order.entities.Book;
import com.capg.order.entities.BookPair;
import com.capg.order.entities.Order;
import com.capg.order.entities.OrderDTO;
import com.capg.order.repository.BookClient;
import com.capg.order.repository.OrderRepository;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class OrderServiceImpl implements OrderService{
	
	private OrderRepository orderrepo;
	
	private BookClient bclient;
	
	OrderServiceImpl(OrderRepository orderrepo,BookClient bclient){
		this.orderrepo = orderrepo; 
		this.bclient = bclient;
	}

	@Override
	public Order addOrder(OrderDTO obj) {
		
		Order order = new Order();
		
		order.setCustomerName(obj.getCustomerName());
		order.setPhone(obj.getPhoneNumber());
		order.setOrderDate(LocalDate.now());
		
		List<Long> bookids = new ArrayList<>();
		
		double totalPrice = 0;
		for(int i=0;i<obj.getBooks().size();i++) {
			
			BookPair bpair = obj.getBooks().get(i);
			
			Book book = bclient.getBookById(bpair.getBookId());
			
			bookids.add(book.getId());
			
			totalPrice += bpair.getQuantity() * book.getPrice();
		}
		
		order.setBookIds(bookids);
		order.setTotlePrice(totalPrice);
		order.setOrderStatus("Confirmed!!");
		
		return orderrepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderrepo.findAll();
	}

	@Override
	public Order getOrderById(long id) {
		return orderrepo.findById(id);
	}

	@Override
	public Order updateOrder(long id, OrderDTO obj) {
		
        Order order = new Order();
		
		order.setCustomerName(obj.getCustomerName());
		order.setPhone(obj.getPhoneNumber());
		order.setOrderDate(LocalDate.now());
		
		List<Long> bookids = new ArrayList<>();
		
		double totalPrice = 0;
		for(int i=0;i<obj.getBooks().size();i++) {
			
			BookPair bpair = obj.getBooks().get(i);
			
			Book book = bclient.getBookById(bpair.getBookId());
			
			bookids.add(book.getId());
			
			totalPrice += bpair.getQuantity() * book.getPrice();
		}
		
		order.setBookIds(bookids);
		order.setTotlePrice(totalPrice);
		order.setOrderStatus("Confirmed!!");
		
		Order order1 = orderrepo.findById(id);
		
		order1.setCustomerName(order.getCustomerName());
		
		order1.setOrderDate(order.getOrderDate());
		
		order1.setOrderStatus(order.getOrderStatus());
		
		order1.setPhone(order.getPhone());
		
		order1.setTotlePrice(order.getTotlePrice());
		
		return order1;
	}

	@Override
	public void deleteOrder(long id) {
		orderrepo.deleteById(id);
	}

}
