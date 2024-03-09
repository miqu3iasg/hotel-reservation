package com.medeiros.reservation.exceptions.customer;

public class CustomerNotFoundException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Customer not found in database.";

  public CustomerNotFoundException(String message) {
    super(message);
  }

  public CustomerNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public CustomerNotFoundException() {
    super(DEFAULT_MESSAGE);
  }
}
