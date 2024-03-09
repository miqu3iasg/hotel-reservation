package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.reservation.ReservationStatus;
import com.medeiros.reservation.exceptions.reservation.ReservationNotFoundException;
import com.medeiros.reservation.repositories.ReservationRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FinalizeReservationAndMarkAsCompleted {
  private final ReservationRepository reservationRepository;

  public FinalizeReservationAndMarkAsCompleted(ReservationRepository reservationRepository) {
    this.reservationRepository = reservationRepository;
  }

  public Reservation completeReservation(UUID reservationId) {
    Reservation reservation = findReservationByIdOrElseThrowException(reservationId);

    updateReservationStatus(reservation);

    updateReservationDetails(reservation);

    updateRoomAvailability(reservation);

    return reservationRepository.save(reservation);
  }

  private Reservation findReservationByIdOrElseThrowException(UUID reservationId) {
    return reservationRepository.findById(reservationId)
            .orElseThrow(ReservationNotFoundException::new);
  }

  private void updateReservationStatus(Reservation reservation) {
    reservation.setStatus(ReservationStatus.COMPLETED);
  }

  private void updateReservationDetails(Reservation reservation) {
    reservation.setCheckOut(TimeProvider.getInstance().setCheckOutLocalDateTime());
    reservation.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());
  }

  private void updateRoomAvailability(Reservation reservation) {
    reservation.getRoom().setAvailability(true);
  }
}
