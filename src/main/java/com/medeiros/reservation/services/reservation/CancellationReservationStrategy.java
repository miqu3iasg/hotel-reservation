package br.com.medeiros.hotelreservation.usecases.reservation;

import java.util.UUID;

public interface CancellationReservationStrategy {
  void cancelReservation(UUID reservationId);
}
