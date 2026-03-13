package com.hotelmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelmanagement.entity.Booking;
import com.hotelmanagement.entity.Room;
import com.hotelmanagement.exception.BookingNotFoundException;
import com.hotelmanagement.exception.RoomNotFoundException;
import com.hotelmanagement.repository.BookingRepository;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.service.BookingService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;

    public BookingServiceImpl(BookingRepository bookingRepository, RoomRepository roomRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public Booking createBooking(Booking booking) {

        Integer id = booking.getRoom().getRoomId();

        Room room = roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + id + " not found"));
        
        if(room.getStatus().equals("Available")) {
        	room.setStatus("Occupied");
        }
        booking.setRoom(room);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
    	List<Booking> bookings = new ArrayList<>();
        bookingRepository.findAll().forEach(b1 -> bookings.add(b1));;
        return bookings;
    }

    @Override
    public Booking getBookingById(int id) {

        return bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + id + " not found"));
    }

    @Override
    public Booking updateBooking(int id, Booking booking) {

        Booking existing = getBookingById(id);

        existing.setCheckInDate(booking.getCheckInDate());
        existing.setCheckOutDate(booking.getCheckOutDate());
        existing.setCustomerName(booking.getCustomerName());
        existing.setCustomerPhone(booking.getCustomerPhone());

        Integer roomId = booking.getRoom().getRoomId();

        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + roomId + " not found"));

        existing.setRoom(room);

        return bookingRepository.save(existing);
    }

    @Override
    public void cancelBooking(int id) {

        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new BookingNotFoundException("Booking with id " + id + " not found"));

        bookingRepository.delete(booking);
    }
}