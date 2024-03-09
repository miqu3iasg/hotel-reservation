package com.medeiros.reservation.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeProvider {
  private static TimeProvider instance;

  private TimeProvider() {
  }

  public static TimeProvider getInstance() {
    if(instance == null) instance = new TimeProvider();

    return instance;
  }

  public LocalDateTime setLocalDateTime() {
    return LocalDateTime.now();
  }

  public LocalDateTime setCheckInLocalDateTime() {
    return LocalDateTime.now();
  }

  public LocalDateTime setCheckOutLocalDateTime() {
    return LocalDateTime.now();
  }

  public LocalDate setLocalDate() {
    return LocalDate.now();
  }

  public LocalTime setLocalTime() {
    return LocalTime.now();
  }
}

