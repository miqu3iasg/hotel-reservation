package com.medeiros.reservation.controllers.hotel;

import com.medeiros.reservation.dtos.hotel.RegisterHotelDTO;
import com.medeiros.reservation.entities.hotel.Hotel;
import com.medeiros.reservation.services.hotel.RegisterHotel;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/hotel/register")
public class RegisterHotelController {

  private final RegisterHotel registerHotelService;

  public RegisterHotelController(RegisterHotel registerHotelService) {
    this.registerHotelService = registerHotelService;
  }

  @PostMapping
  ResponseEntity<Hotel> registerHotel(@RequestBody @Valid RegisterHotelDTO hotelDataRequest) {
    return new ResponseEntity<>(registerHotelService.register(hotelDataRequest), HttpStatus.CREATED);
  }
}
