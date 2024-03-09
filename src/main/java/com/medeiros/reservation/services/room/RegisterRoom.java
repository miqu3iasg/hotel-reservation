package com.medeiros.reservation.services.room;

import com.medeiros.reservation.dtos.room.RegisterHotelRoomDTO;
import com.medeiros.reservation.entities.hotel.Hotel;
import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.exceptions.hotel.HotelDoesNotExistsException;
import com.medeiros.reservation.exceptions.room.RoomAlreadyExistsExeption;
import com.medeiros.reservation.repositories.HotelRepository;
import com.medeiros.reservation.repositories.RoomRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

@Service
public class RegisterRoom {
  private final HotelRepository hotelRepository;
  private final RoomRepository roomRepository;

  public RegisterRoom (
          HotelRepository hotelRepository,
          RoomRepository roomRepository
  ) {
    this.hotelRepository = hotelRepository;
    this.roomRepository = roomRepository;
  }

  public Room register(RegisterHotelRoomDTO roomDataRequest) {
    Hotel hotelFound = checkHotelExistsByName(roomDataRequest.getHotelName());

    checkRoomExistsByNumber(roomDataRequest.getNumber());

    Room room = createRoomFromRequest(roomDataRequest, hotelFound);

    return roomRepository.save(room);
  }

  private Hotel checkHotelExistsByName(String name) {
    Hotel hotel = hotelRepository.findByName(name);

    if(hotel == null) throw new HotelDoesNotExistsException();

    return hotel;
  }

  private void checkRoomExistsByNumber(int number) {
    if(roomRepository.findByNumber(number).isPresent()) throw new RoomAlreadyExistsExeption();
  }

  private Room createRoomFromRequest(RegisterHotelRoomDTO roomDataRequest, Hotel hotel) {
    Room room = new Room();

    room.setNumber(roomDataRequest.getNumber());
    room.setType(roomDataRequest.getType());
    room.setDescription(roomDataRequest.getDescription());
    room.setPricePerNight(roomDataRequest.getPricePerNight());
    room.setHotel(hotel);
    room.setAvailability(true);
    room.setCreatedAt(TimeProvider.getInstance().setLocalDateTime());
    room.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());

    return room;
  }
}
