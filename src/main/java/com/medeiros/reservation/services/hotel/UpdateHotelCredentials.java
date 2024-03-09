package com.medeiros.reservation.services.hotel;

import com.medeiros.reservation.dtos.hotel.UpdateHotelDTO;
import com.medeiros.reservation.entities.hotel.Hotel;
import com.medeiros.reservation.exceptions.hotel.HotelDoesNotExistsException;
import com.medeiros.reservation.repositories.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateHotelCredentials {
  private final HotelRepository hotelRepository;

  public UpdateHotelCredentials(HotelRepository hotelRepository) {
    this.hotelRepository = hotelRepository;
  }

  public Hotel updateHotel(UUID hotelId, UpdateHotelDTO hotelDataRequest) {
    return hotelRepository.findById(hotelId)
            .map(hotelFound -> {
              updateHotelFromRequest(hotelFound, hotelDataRequest);
              return hotelRepository.save(hotelFound);
            }).orElseThrow(HotelDoesNotExistsException::new);
  }

  private Hotel updateHotelFromRequest(Hotel hotel, UpdateHotelDTO hotelDataRequest) {
    hotel.setName(hotelDataRequest.getName());
    hotel.setAddress(hotelDataRequest.getAddress());
    hotel.setStars(hotelDataRequest.getStars());

    return hotel;
  }
}
