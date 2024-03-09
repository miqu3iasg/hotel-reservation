package com.medeiros.reservation.dtos;

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
