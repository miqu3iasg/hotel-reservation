package com.medeiros.reservation.entities.phonenumber;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class PhoneNumber {
  private static final String PHONE_NUMBER_REGEX = "^(\\+\\d{1,3}[- ]?)?\\(?\\d{1,4}\\)?[- ]?\\d{6,}$";

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String phoneNumber;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public PhoneNumber(String phoneNumber) {
    //isValidPhoneNumber();

    this.phoneNumber = phoneNumber;
  }

  public void isValidPhoneNumber() {
    if (phoneNumber == null || !phoneNumber.matches(PHONE_NUMBER_REGEX)) {
      throw new IllegalArgumentException("invalid phone number");
    }
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}

