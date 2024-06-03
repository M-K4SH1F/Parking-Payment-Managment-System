CREATE DATABASE ParkingLotDB;

USE ParkingLotDB;

CREATE TABLE ParkingLot(
  ticketId INT UNIQUE PRIMARY KEY,
  spotID varchar(2),
  isOccupied BOOLEAN NOT NULL,
  vehiclePlate varchar(7),
  checkInTime DATETIME,
  checkOutTime DATETIME,
  actualCheckOutTime DATETIME
);

CREATE USER 'testuser'@'localhost' IDENTIFIED BY 'pass';
GRANT ALL PRIVILEGES ON ParkingLotDB.* TO 'testuser'@'localhost';
FLUSH PRIVILEGES;

TRUNCATE TABLE ParkingLot; -- to clear table