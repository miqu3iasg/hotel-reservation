package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.reservation.ReservationStatus;
import com.medeiros.reservation.exceptions.reservation.ReservationNotFoundException;
import com.medeiros.reservation.repositories.ReservationRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ReactivateAndConfirmReservation {
  private final ReservationRepository reservationRepository;

  public ReactivateAndConfirmReservation(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public void reactive(UUID reservationId) {
    Reservation reservation = findReservationByIdOrElseThrowException(reservationId);

    validateIfReservationCanBeReactivated(reservation);

    updateReservationStatusAndDetails(reservation);

    reservationRepository.save(reservation);
  }

  private Reservation findReservationByIdOrElseThrowException(UUID reservationId) {
    return reservationRepository.findById(reservationId)
            .orElseThrow(ReservationNotFoundException::new);
  }

  private void validateIfReservationCanBeReactivated(Reservation reservation) {
    if(!(reservation.getStatus() == ReservationStatus.CANCELED)) throw new IllegalStateException("Reservation cannot be reactivated.");
  }

  private void updateReservationStatusAndDetails(Reservation reservation) {
    reservation.setStatus(ReservationStatus.CONFIRMED);
    reservation.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());
  }
}
