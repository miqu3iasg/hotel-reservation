package com.medeiros.reservation.entities.room;

import com.medeiros.reservation.entities.reservation.Reservation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
public class Room {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID id;
  private int number;
  private RoomType type;
  private BigDecimal pricePerNight;
  private boolean availability;
  private String description;

  @ManyToOne
  @JoinColumn(name = "hotel_id")
  private String hotel;

  @OneToMany(mappedBy = "room")
  private List<Reservation> reservations;

  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) {
    this.number = number;
  }

  public RoomType getType() {
    return type;
  }

  public void setType(RoomType type) {
    this.type = type;
  }

  public BigDecimal getPricePerNight() {
    return pricePerNight;
  }

  public void setPricePerNight(BigDecimal pricePerNight) {
    this.pricePerNight = pricePerNight;
  }

  public boolean isAvailability() {
    return availability;
  }

  public void setAvailability(boolean availability) {
    this.availability = availability;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getHotel() {
    return hotel;
  }

  public void setHotel(String hotel) {
    this.hotel = hotel;
  }

  public List<Reservation> getReservations() {
    return reservations;
  }

  public void setReservations(List<Reservation> reservations) {
    this.reservations = reservations;
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

