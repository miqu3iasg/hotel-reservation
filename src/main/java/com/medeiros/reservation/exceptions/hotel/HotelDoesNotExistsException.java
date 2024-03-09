package com.medeiros.reservation.exceptions.hotel;

public class HotelDoesNotExistsException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Hotel does not exists.";

  public HotelDoesNotExistsException(String message) {
    super(message);
  }

  public HotelDoesNotExistsException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public HotelDoesNotExistsException() {
    super(DEFAULT_MESSAGE);
  }
}
