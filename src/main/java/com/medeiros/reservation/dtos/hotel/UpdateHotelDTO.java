package com.medeiros.reservation.dtos.hotel;

import com.medeiros.reservation.entities.address.Address;

public class UpdateHotelDTO {
  private String name;
  private Address address;
  private int stars;

  public String getName() {
    return name;
  }

  public Address getAddress() {
    return address;
  }

  public int getStars() {
    return stars;
  }
}
