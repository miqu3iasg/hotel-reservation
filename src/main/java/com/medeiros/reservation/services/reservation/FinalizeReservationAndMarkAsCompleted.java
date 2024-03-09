package br.com.medeiros.hotelreservation.usecases.reservation;

import br.com.medeiros.hotelreservation.entities.reservation.Reservation;
import br.com.medeiros.hotelreservation.entities.reservation.ReservationStatus;
import br.com.medeiros.hotelreservation.exceptions.ReservationNotFoundException;
import br.com.medeiros.hotelreservation.repositories.ReservationRepository;
import br.com.medeiros.hotelreservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

import java.sql.Time;
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
