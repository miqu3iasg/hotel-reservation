package com.medeiros.reservation.exceptions.room;

public class RoomNotFoundException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Room not found in database.";

  public RoomNotFoundException(String message) {
    super(message);
  }

  public RoomNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public RoomNotFoundException() {
    super(DEFAULT_MESSAGE);
  }
}
