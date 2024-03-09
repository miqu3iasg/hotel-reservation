package com.medeiros.reservation.dtos.room;

import java.time.LocalDateTime;

public class GetRoomsThatAreAvailableBetweenDatesDTO {
  LocalDateTime checkIn;
  LocalDateTime checkOut;

  public LocalDateTime getCheckIn() {
    return checkIn;
  }

  public LocalDateTime getCheckOut() {
    return checkOut;
  }
}
