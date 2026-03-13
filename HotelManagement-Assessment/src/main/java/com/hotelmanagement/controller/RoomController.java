package com.hotelmanagement.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelmanagement.entity.Room;
import com.hotelmanagement.service.RoomService;

@RestController
@RequestMapping("/rooms")
public class RoomController {
	
	private final RoomService roomService;
	
	public RoomController(RoomService roomService) {
		this.roomService=roomService;
	}
	
	@PostMapping
	public ResponseEntity<Room> addRoom(@RequestBody Room room){
		Room r1 = roomService.addRoom(room);
		return new ResponseEntity<>(r1,HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Room>> getAllRooms(){
		List<Room> rooms = roomService.getAllRooms();
		return new ResponseEntity<>(rooms,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Room> getRoomById(@PathVariable int id){
		Room room = roomService.getRoomById(id);
		return new ResponseEntity<>(room,HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Room> updateRoomById(@PathVariable int id,@RequestBody Room room){
		Room r1 = roomService.updateRoom(id, room);
		return new ResponseEntity<>(r1,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteRoomById(@PathVariable int id){
		roomService.deleteRoom(id);
		return ResponseEntity.ok("Room Deleted");
	}
	
	
}
