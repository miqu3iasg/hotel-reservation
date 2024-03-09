package br.com.medeiros.hotelreservation.usecases.reservation;

import br.com.medeiros.hotelreservation.entities.reservation.Reservation;
import br.com.medeiros.hotelreservation.entities.reservation.ReservationStatus;
import br.com.medeiros.hotelreservation.exceptions.ReservationNotFoundException;
import br.com.medeiros.hotelreservation.repositories.ReservationRepository;
import br.com.medeiros.hotelreservation.utils.TimeProvider;
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
