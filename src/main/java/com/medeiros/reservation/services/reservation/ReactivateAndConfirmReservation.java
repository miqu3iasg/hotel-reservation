package br.com.medeiros.hotelreservation.usecases.reservation;

import br.com.medeiros.hotelreservation.entities.reservation.Reservation;
import br.com.medeiros.hotelreservation.entities.reservation.ReservationStatus;
import br.com.medeiros.hotelreservation.exceptions.ReservationNotFoundException;
import br.com.medeiros.hotelreservation.repositories.ReservationRepository;
import br.com.medeiros.hotelreservation.utils.TimeProvider;
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
