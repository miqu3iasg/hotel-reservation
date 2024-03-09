package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.reservation.ReservationStatus;
import com.medeiros.reservation.exceptions.reservation.ReservationNotFoundException;
import com.medeiros.reservation.repositories.ReservationRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class MarkReservationAsCanceled implements CancellationReservationStrategy {
  private final ReservationRepository reservationRepository;

  public MarkReservationAsCanceled(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void cancelReservation(UUID reservationId) {
    Reservation reservation = findReservationByIdOrElseThrowException(reservationId);

    updateReservationStatus(reservation);

    updateReservationDetails(reservation);

    updateRoomAvailability(reservation);

    reservationRepository.save(reservation);
  }

  private Reservation findReservationByIdOrElseThrowException(UUID reservationId) {
    return reservationRepository.findById(reservationId)
            .orElseThrow(ReservationNotFoundException::new);
  }

  private void updateReservationStatus(Reservation reservation) {
    reservation.setStatus(ReservationStatus.CANCELED);
  }

  private void updateReservationDetails(Reservation reservation) {
    reservation.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());
  }

  private void updateRoomAvailability(Reservation reservation) {
    reservation.getRoom().setAvailability(true);
  }
}
