package com.hotelmanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelmanagement.entity.Room;
import com.hotelmanagement.exception.RoomCannotBeDeletedException;
import com.hotelmanagement.exception.RoomNotFoundException;
import com.hotelmanagement.repository.RoomRepository;
import com.hotelmanagement.service.RoomService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
    	List<Room> rooms = new ArrayList<>(); 
    	roomRepository.findAll().forEach(r1 -> rooms.add(r1)); 
    	return rooms;
    }

    @Override
    public Room getRoomById(int id) {

        return roomRepository.findById(id)
                .orElseThrow(() -> new RoomNotFoundException("Room with id " + id + " not found"));
    }

    @Override
    public Room updateRoom(int id, Room room) {

        Room existing = getRoomById(id);

        existing.setRoomNumber(room.getRoomNumber());
        existing.setRoomType(room.getRoomType());
        existing.setPrice(room.getPrice());
        existing.setStatus(room.getStatus());

        return roomRepository.save(existing);
    }

    @Override
    public void deleteRoom(int id) {

        Room room = getRoomById(id);

        if (room.getBookings() != null && !room.getBookings().isEmpty()) {
            throw new RoomCannotBeDeletedException("Room cannot be deleted because bookings exist");
        }

        roomRepository.delete(room);
    }
}