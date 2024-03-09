package com.medeiros.reservation.dtos.customer;

import com.medeiros.reservation.entities.phonenumber.PhoneNumber;

public class CreateCustomerDTO {
  private String firstName;
  private String lastName;
  private String email;
  private PhoneNumber phoneNumber;

  public CreateCustomerDTO(String firstName, String lastName, String email, PhoneNumber phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

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

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}
