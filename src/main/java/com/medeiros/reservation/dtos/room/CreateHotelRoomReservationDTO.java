package com.medeiros.reservation.dtos.room;

public class CreateHotelRoomReservationDTO {
  private String customerEmail;
  private int hotelRoomNumber;

  public String getCustomerEmail() {
    return customerEmail;
  }

  public int getHotelRoomNumber() {
    return hotelRoomNumber;
  }
}
