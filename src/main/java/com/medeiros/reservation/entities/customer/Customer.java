package com.medeiros.reservation.entities.customer;

import com.medeiros.reservation.entities.phonenumber.PhoneNumber;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Pattern;

@Entity
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private String firstName;
  private String lastName;
  private String email;

  @OneToOne(cascade = CascadeType.ALL)
  private PhoneNumber phoneNumber;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private static final String EMAIL_REGEX_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n";

  public boolean isValidEmailFormat(final String email) {
    Pattern pattern = Pattern.compile(EMAIL_REGEX_PATTERN);
    return pattern.matcher(email).matches();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(PhoneNumber phoneNumber) {
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

