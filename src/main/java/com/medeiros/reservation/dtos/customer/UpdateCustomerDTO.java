package com.medeiros.reservation.dtos.customer;

import com.medeiros.reservation.entities.phonenumber.PhoneNumber;

public class UpdateCustomerDTO {
  private String firstName;
  private String lastName;
  private String email;
  private PhoneNumber phoneNumber;

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getEmail() {
    return email;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }
}
