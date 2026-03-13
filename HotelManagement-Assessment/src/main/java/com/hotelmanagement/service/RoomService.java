package com.hotelmanagement.service;

import java.util.List;

import com.hotelmanagement.entity.Room;

public interface RoomService {
	public Room addRoom(Room room);
	
	public List<Room> getAllRooms();
	
	public Room getRoomById(int id);
	
	public Room updateRoom(int id,Room room);
	
	public void deleteRoom(int id);
}
