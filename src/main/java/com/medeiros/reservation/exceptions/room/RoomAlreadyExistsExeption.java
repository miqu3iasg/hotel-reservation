package com.medeiros.reservation.exceptions.room;

public class RoomAlreadyExistsExeption extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Room already exists.";

  public RoomAlreadyExistsExeption(String message) {
    super(message);
  }

  public RoomAlreadyExistsExeption(String message, Throwable throwable) {
    super(message, throwable);
  }

  public RoomAlreadyExistsExeption() {
    super(DEFAULT_MESSAGE);
  }
}
