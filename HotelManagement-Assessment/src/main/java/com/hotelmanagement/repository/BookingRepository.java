package com.hotelmanagement.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hotelmanagement.entity.Booking;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Integer> {

}
