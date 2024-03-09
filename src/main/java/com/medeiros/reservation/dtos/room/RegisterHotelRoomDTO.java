package com.medeiros.reservation.dtos;

import com.medeiros.reservation.entities.room.RoomType;

import java.math.BigDecimal;

public class RegisterHotelRoomDTO {
  private int number;
  private RoomType type;
  private BigDecimal pricePerNight;
  private String hotelName;
  private String description;

  public RegisterHotelRoomDTO (
          int number,
          RoomType type,
          BigDecimal pricePerNight,
          String hotelName,
          String description
  ) {
    this.number = number;
    this.type = type;
    this.pricePerNight = pricePerNight;
    this.hotelName = hotelName;
    this.description = description;
  }

  public int getNumber() {
    return number;
  }

  public RoomType getType() {
    return type;
  }

  public BigDecimal getPricePerNight() {
    return pricePerNight;
  }

  public String getHotelName() {
    return hotelName;
  }

  public String getDescription() {
    return description;
  }
}
