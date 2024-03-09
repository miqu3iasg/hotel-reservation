package com.medeiros.reservation.controllers.hotel;

import com.medeiros.reservation.dtos.hotel.UpdateHotelDTO;
import com.medeiros.reservation.entities.hotel.Hotel;
import com.medeiros.reservation.services.hotel.UpdateHotelCredentials;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/hotel/update-hotel/{hotelId}")
public class UpdateHotelCredentialsController {

  private final UpdateHotelCredentials updateHotelCredentialsService;

  public UpdateHotelCredentialsController(UpdateHotelCredentials updateHotelCredentialsService) {
    this.updateHotelCredentialsService = updateHotelCredentialsService;
  }

  ResponseEntity<Hotel> updateHotel(@PathVariable UUID hotelId, @RequestBody @Valid UpdateHotelDTO hotelDataRequest) {
    return new ResponseEntity<>(updateHotelCredentialsService.updateHotel(hotelId, hotelDataRequest), HttpStatus.OK);
  }
}
