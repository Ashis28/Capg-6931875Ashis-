
HOTEL MANAGEMENT API TESTING GUIDE
----------------------------------


ROOM APIs
---------

1) GET ALL ROOMS
GET http://localhost:9091/rooms

Response:
[
  {
    "roomId": 101,
    "roomNumber": "R101",
    "roomType": "Deluxe",
    "price": 3500,
    "status": "Available"
  },
  {
    "roomId": 102,
    "roomNumber": "R102",
    "roomType": "Standard",
    "price": 2000,
    "status": "Available"
  }
]


2) ADD ROOM
POST http://localhost:9091/rooms

Body (raw JSON):
{
  "roomId": 104,
  "roomNumber": "R104",
  "roomType": "Suite",
  "price": 5500,
  "status": "Available"
}


3) GET ROOM BY ID
GET http://localhost:9091/rooms/101

Response:
{
  "roomId": 101,
  "roomNumber": "R101",
  "roomType": "Deluxe",
  "price": 3500,
  "status": "Available"
}


4) UPDATE ROOM
PUT http://localhost:9091/rooms/101

Body (raw JSON):
{
  "roomNumber": "R101",
  "roomType": "Deluxe",
  "price": 4000,
  "status": "Occupied"
}


5) DELETE ROOM
DELETE http://localhost:9091/rooms/101

Response:
Room Deleted



BOOKING APIs
------------

1) GET ALL BOOKINGS
GET http://localhost:9091/bookings

Response:
[
  {
    "bookingId": 1,
    "customerName": "Ram",
    "customerPhone": "9876543210",
    "checkInDate": "2026-03-10",
    "checkOutDate": "2026-03-12"
  }
]


2) CREATE BOOKING
POST http://localhost:9091/bookings

Body (raw JSON):
{
  "bookingId": 3,
  "customerName": "Suresh",
  "customerPhone": "9998887776",
  "checkInDate": "2026-03-20",
  "checkOutDate": "2026-03-22",
  "room": {
    "roomId": 101
  }
}


3) GET BOOKING BY ID
GET http://localhost:9091/bookings/1

Response:
{
  "bookingId": 1,
  "customerName": "Ram",
  "customerPhone": "9876543210",
  "checkInDate": "2026-03-10",
  "checkOutDate": "2026-03-12"
}


4) UPDATE BOOKING
PUT http://localhost:9091/bookings/1

Body (raw JSON):
{
  "customerName": "Ram Kumar",
  "customerPhone": "9876543210",
  "checkInDate": "2026-03-11",
  "checkOutDate": "2026-03-13",
  "room": {
    "roomId": 102
  }
}


5) CANCEL BOOKING
DELETE http://localhost:9091/bookings/1

Response:
Booking Cancelled



