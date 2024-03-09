package br.com.medeiros.hotelreservation.controllers.reservation;

import br.com.medeiros.hotelreservation.entities.reservation.Reservation;
import br.com.medeiros.hotelreservation.usecases.reservation.FinalizeReservationAndMarkAsCompleted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/reservation/finalize-reservation/{reservationId}")
public class FinalizeReservationAndMarkAsCompletedController {

  private final FinalizeReservationAndMarkAsCompleted finalizeReservationAndMarkAsCompletedService;

  public FinalizeReservationAndMarkAsCompletedController(FinalizeReservationAndMarkAsCompleted finalizeReservationAndMarkAsCompletedService) {
    this.finalizeReservationAndMarkAsCompletedService = finalizeReservationAndMarkAsCompletedService;
  }

  @PatchMapping
  ResponseEntity<Reservation> completeReservation(@PathVariable UUID reservationId) {
    return new ResponseEntity<>(finalizeReservationAndMarkAsCompletedService.completeReservation(reservationId), HttpStatus.OK);
  }

}
