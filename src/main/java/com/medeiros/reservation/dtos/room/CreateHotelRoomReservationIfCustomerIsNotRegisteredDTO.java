package com.medeiros.reservation.dtos;

public class CreateHotelRoomReservationIfCustomerIsNotRegisteredDTO {
  private CreateCustomerDTO customer;
  private int hotelRoomNumber;

  public CreateCustomerDTO getCustomer() {
    return customer;
  }

  public int getHotelRoomNumber() {
    return hotelRoomNumber;
  }
}
