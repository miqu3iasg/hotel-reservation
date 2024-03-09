package com.medeiros.reservation.services.hotel;

import com.medeiros.reservation.dtos.hotel.RegisterHotelDTO;
import com.medeiros.reservation.entities.hotel.Hotel;
import com.medeiros.reservation.exceptions.hotel.HotelAlreadyExistsException;
import com.medeiros.reservation.repositories.HotelRepository;
import com.medeiros.reservation.utils.TimeProvider;
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
