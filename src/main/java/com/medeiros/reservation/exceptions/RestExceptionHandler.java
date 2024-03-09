package br.com.medeiros.hotelreservation.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

  @ExceptionHandler(CustomerNotFoundException.class)
  ResponseEntity<String> customerNotFoundExceptionHandler(CustomerNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler(ReservationNotFoundException.class)
  ResponseEntity<String> reservationNotFoundExceptionHandler(ReservationNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler(RoomNotFoundException.class)
  ResponseEntity<String> roomNotFoundExceptionHandler(RoomNotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler(HotelDoesNotExistsException.class)
  ResponseEntity<String> hotelDoesNotExistsExceptionHandler(HotelDoesNotExistsException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

  @ExceptionHandler(CustomerAlreadyExistsException.class)
  ResponseEntity<String> customerAlreadyExistsExceptionHandler(CustomerAlreadyExistsException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(HotelAlreadyExistsException.class)
  ResponseEntity<String> hotelAlreadyExistsExceptionHandler(HotelAlreadyExistsException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @ExceptionHandler(RoomAlreadyExistsExeption.class)
  ResponseEntity<String> roomAlreadyExistsExceptionHandler(RoomAlreadyExistsExeption exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }
}
