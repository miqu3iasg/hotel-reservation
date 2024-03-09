package br.com.medeiros.hotelreservation.controllers.reservation;

import br.com.medeiros.hotelreservation.usecases.reservation.MarkReservationAsCanceled;
import br.com.medeiros.hotelreservation.usecases.reservation.ReactivateAndConfirmReservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/reservation/reactivate-reservation/{reservationId}")
public class ReactivateAndConfirmReservationController {

  private final ReactivateAndConfirmReservation reactivateAndConfirmReservationService;

  public ReactivateAndConfirmReservationController(ReactivateAndConfirmReservation reactivateAndConfirmReservationService) {
    this.reactivateAndConfirmReservationService = reactivateAndConfirmReservationService;
  }

  @PatchMapping
  ResponseEntity<HttpStatus> reactive(@PathVariable UUID reservationId) {
    reactivateAndConfirmReservationService.reactive(reservationId);
    return ResponseEntity.ok().build();
  }
}
