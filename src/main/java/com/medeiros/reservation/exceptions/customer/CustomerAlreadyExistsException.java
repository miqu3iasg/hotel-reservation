package com.medeiros.reservation.exceptions.customer;

public class CustomerAlreadyExistsException extends RuntimeException {
  private static final String DEFAULT_MESSAGE = "Customer already exists.";

  public CustomerAlreadyExistsException(String message) {
    super(message);
  }

  public CustomerAlreadyExistsException(String message, Throwable throwable) {
    super(message, throwable);
  }

  public CustomerAlreadyExistsException() {
    super(DEFAULT_MESSAGE);
  }
}
