package com.medeiros.reservation.dtos.hotel;

import com.medeiros.reservation.entities.address.Address;

public class RegisterHotelDTO {
  private String name;
  private Address address;
  private int stars;

  public RegisterHotelDTO(String name, Address address, int stars) {
    this.name = name;
    this.address = address;
    this.stars = stars;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public int getStars() {
    return stars;
  }

  public void setStars(int stars) {
    this.stars = stars;
  }
}
