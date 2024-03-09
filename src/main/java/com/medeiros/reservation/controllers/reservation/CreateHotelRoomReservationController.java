package com.medeiros.reservation.controllers.reservation;

import com.medeiros.reservation.dtos.room.CreateHotelRoomReservationDTO;
import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.services.reservation.CreateHotelRoomReservation;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/reservation/create")
public class CreateHotelRoomReservationController {

  private final CreateHotelRoomReservation createHotelRoomReservationService;

  public CreateHotelRoomReservationController(CreateHotelRoomReservation createHotelRoomReservationService) {
    this.createHotelRoomReservationService = createHotelRoomReservationService;
  }

  @PostMapping
  ResponseEntity<Reservation> createReservation(@RequestBody @Valid CreateHotelRoomReservationDTO reservationDataRequest) {
    return new ResponseEntity<>(createHotelRoomReservationService.createReservation(reservationDataRequest), HttpStatus.CREATED);
  }
}
