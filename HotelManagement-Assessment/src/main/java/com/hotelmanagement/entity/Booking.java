package com.hotelmanagement.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	@Id
	private Integer bookingId;
	
	private String customerName;
	
	private String customerPhone;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "roomId")
	@JsonBackReference
	private Room room;

	public Booking() {
		
	}
	public Booking(Integer bookingId, String customerName, String customerPhone, LocalDate checkInDate,
			LocalDate checkOutDate, Room room) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.checkInDate = checkInDate;
		this.checkOutDate = checkOutDate;
		this.room = room;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public LocalDate getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(LocalDate checkInDate) {
		this.checkInDate = checkInDate;
	}

	public LocalDate getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(LocalDate checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
}
