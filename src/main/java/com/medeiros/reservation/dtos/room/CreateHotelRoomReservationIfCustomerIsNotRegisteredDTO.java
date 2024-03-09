package com.medeiros.reservation.dtos.room;

import com.medeiros.reservation.dtos.customer.CreateCustomerDTO;

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
