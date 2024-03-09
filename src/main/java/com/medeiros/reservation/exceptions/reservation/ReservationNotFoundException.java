package com.medeiros.reservation.exceptions.reservation;

public class ReservationNotFoundException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Reservation not found in database.";

  public ReservationNotFoundException(String message) {
    super(message);
  }

  public ReservationNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public ReservationNotFoundException() {
    super(DEFAULT_MESSAGE);
  }
}
