package com.hotelmanagement.service;

import java.util.List;

import com.hotelmanagement.entity.Booking;
import com.hotelmanagement.entity.Room;

public interface BookingService {
	
	public Booking createBooking(Booking booking);
	
	public List<Booking> getAllBookings();
	
	public Booking getBookingById(int id);
	
	public Booking updateBooking(int id, Booking booking);
	
	public void cancelBooking(int id);
	
}
