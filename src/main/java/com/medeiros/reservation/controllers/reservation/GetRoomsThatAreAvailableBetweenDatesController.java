package br.com.medeiros.hotelreservation.controllers.reservation;

import br.com.medeiros.hotelreservation.dtos.GetRoomsThatAreAvailableBetweenDatesDTO;
import br.com.medeiros.hotelreservation.entities.room.Room;
import br.com.medeiros.hotelreservation.usecases.reservation.GetRoomsThatAreAvailableBetweenDates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/reservation/get-rooms-available-between-dates/{roomNumber}")
public class GetRoomsThatAreAvailableBetweenDatesController {

  private final GetRoomsThatAreAvailableBetweenDates getRoomsThatAreAvailableBetweenDatesService;

  public GetRoomsThatAreAvailableBetweenDatesController(GetRoomsThatAreAvailableBetweenDates getRoomsThatAreAvailableBetweenDatesService) {
    this.getRoomsThatAreAvailableBetweenDatesService = getRoomsThatAreAvailableBetweenDatesService;
  }

  @GetMapping
  ResponseEntity<List<Room>> findAvailableRooms(@PathVariable int roomNumber, @RequestBody GetRoomsThatAreAvailableBetweenDatesDTO checkInAndCheckOutTimeData) {
    return new ResponseEntity<>(getRoomsThatAreAvailableBetweenDatesService.findAvaibleRooms(roomNumber, checkInAndCheckOutTimeData.getCheckIn(), checkInAndCheckOutTimeData.getCheckOut()), HttpStatus.OK);
  }
}
