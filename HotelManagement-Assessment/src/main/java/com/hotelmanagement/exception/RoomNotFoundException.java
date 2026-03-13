package com.hotelmanagement.exception;

public class RoomNotFoundException extends RuntimeException {
	public RoomNotFoundException(String msg) {
		super(msg);
	}
}
