package com.medeiros.reservation.services.reservation;

import java.util.UUID;

public interface CancellationReservationStrategy {
  void cancelReservation(UUID reservationId);
}
