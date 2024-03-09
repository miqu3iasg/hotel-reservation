package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.exceptions.reservation.ReservationNotFoundException;
import com.medeiros.reservation.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DeleteAndCancelReservation implements CancellationReservationStrategy {
  private final ReservationRepository reservationRepository;

  public DeleteAndCancelReservation(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  @Override
  public void cancelReservation(UUID reservationId) {
    Reservation reservation = findReservationByIdOrElseThrowException(reservationId);

    updateRoomAvailability(reservation);

    deleteReservation(reservation);
  }

  private Reservation findReservationByIdOrElseThrowException(UUID reservationId) {
    return reservationRepository.findById(reservationId)
            .orElseThrow(ReservationNotFoundException::new);
  }

  private void updateRoomAvailability(Reservation reservation) {
    reservation.getRoom().setAvailability(true);
  }

  private void deleteReservation(Reservation reservation) {
    reservationRepository.delete(reservation);
  }
}
