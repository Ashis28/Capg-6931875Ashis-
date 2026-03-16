package com.capg.order.entities;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderService")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String customerName;
	
	private long phone;
	
	private double totlePrice;
	
	private String orderStatus;
	
	private LocalDate orderDate;
	
	@ElementCollection
	@CollectionTable(name = "order_books",
	        joinColumns = @JoinColumn(name = "order_id"))
	@Column(name = "book_id")
	private List<Long> bookIds;
	
	public Order() {
		
	}

	public Order(String customerName, long phone,int noOfBooksOrdered, double totlePrice, String orderStatus,
			LocalDate orderDate) {
		this.customerName = customerName;
		this.phone = phone;
		this.totlePrice = totlePrice;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public List<Long> getBookIds() {
		return bookIds;
	}

	public void setBookIds(List<Long> bookIds) {
		this.bookIds = bookIds;
	}

	public double getTotlePrice() {
		return totlePrice;
	}

	public void setTotlePrice(double totlePrice) {
		this.totlePrice = totlePrice;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	
	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}
}
