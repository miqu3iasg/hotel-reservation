package com.medeiros.reservation.controllers.reservation;

import com.medeiros.reservation.services.reservation.MarkReservationAsCanceled;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/reservation/cancel-reservation/{reservationId}")
public class MarkReservationAsCanceledController {

  private final MarkReservationAsCanceled markReservationAsCanceledService;

  public MarkReservationAsCanceledController(MarkReservationAsCanceled markReservationAsCanceledService) {
    this.markReservationAsCanceledService = markReservationAsCanceledService;
  }

  @PatchMapping
  ResponseEntity<HttpStatus> cancelReservation(@PathVariable UUID reservationId) {
    markReservationAsCanceledService.cancelReservation(reservationId);
    return ResponseEntity.ok().build();
  }
}
