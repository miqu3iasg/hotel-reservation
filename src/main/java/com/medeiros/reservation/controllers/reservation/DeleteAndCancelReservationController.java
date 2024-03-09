package com.medeiros.reservation.controllers.reservation;

import com.medeiros.reservation.services.reservation.DeleteAndCancelReservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/reservation/delete-reservation/{reservationId}")
public class DeleteAndCancelReservationController {

  private final DeleteAndCancelReservation deleteAndCancelReservationService;

  public DeleteAndCancelReservationController(DeleteAndCancelReservation deleteAndCancelReservationService) {
    this.deleteAndCancelReservationService = deleteAndCancelReservationService;
  }

  @DeleteMapping
  ResponseEntity<HttpStatus> cancelReservation(@PathVariable UUID reservationId) {
    deleteAndCancelReservationService.cancelReservation(reservationId);
    return ResponseEntity.ok().build();
  }
}
