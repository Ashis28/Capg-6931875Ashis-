package com.hotelmanagement.exception;

public class RoomCannotBeDeletedException extends RuntimeException {
	public RoomCannotBeDeletedException(String msg) {
		super(msg);
	}
}
