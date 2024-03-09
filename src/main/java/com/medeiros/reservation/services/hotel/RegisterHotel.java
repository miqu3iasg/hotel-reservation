package com.medeiros.reservation.services.hotel;

import br.com.medeiros.hotelreservation.dtos.RegisterHotelDTO;
import br.com.medeiros.hotelreservation.entities.hotel.Hotel;
import br.com.medeiros.hotelreservation.exceptions.HotelAlreadyExistsException;
import br.com.medeiros.hotelreservation.repositories.HotelRepository;
import br.com.medeiros.hotelreservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

@Service
public class RegisterHotel {

  private final HotelRepository hotelRepository;
  private final TimeProvider timeProvider;

  public RegisterHotel(HotelRepository hotelRepository, TimeProvider timeProvider) {
    this.hotelRepository = hotelRepository;
    this.timeProvider = timeProvider;
  }

  public Hotel register(RegisterHotelDTO hotelDataRequest) {
    checkHotelExistsByName(hotelDataRequest.getName());

    Hotel hotel = createHotelFromRequest(hotelDataRequest);

    updateTimestamps(hotel);

    return hotelRepository.save(hotel);
  }

  private void checkHotelExistsByName(String name) {
    if(hotelRepository.findByName(name) != null) throw new HotelAlreadyExistsException();
  }

  private Hotel createHotelFromRequest(RegisterHotelDTO hotelDataRequest) {
    return new Hotel (
            hotelDataRequest.getName(),
            hotelDataRequest.getAddress(),
            hotelDataRequest.getStars()
    );
  }

  private void updateTimestamps(Hotel hotel) {
    hotel.setCreatedAt(timeProvider.setLocalDateTime());
    hotel.setUpdatedAt(timeProvider.setLocalDateTime());
  }
}
