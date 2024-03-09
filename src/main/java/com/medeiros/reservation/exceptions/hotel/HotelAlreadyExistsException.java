package com.medeiros.reservation.exceptions.hotel;

public class HotelAlreadyExistsException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Hotel already exists.";

  public HotelAlreadyExistsException(String message) {
    super(message);
  }

  public HotelAlreadyExistsException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public HotelAlreadyExistsException() {
    super(DEFAULT_MESSAGE);
  }
}
