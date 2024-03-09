package com.medeiros.reservation.controllers.reservation;

import com.medeiros.reservation.dtos.room.GetRoomsThatAreAvailableBetweenDatesDTO;
import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.services.reservation.GetRoomsThatAreAvailableBetweenDates;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation/get-rooms-available-between-dates/{roomNumber}")
public class GetRoomsThatAreAvailableBetweenDatesController {

  private final GetRoomsThatAreAvailableBetweenDates getRoomsThatAreAvailableBetweenDatesService;

  public GetRoomsThatAreAvailableBetweenDatesController(GetRoomsThatAreAvailableBetweenDates getRoomsThatAreAvailableBetweenDatesService) {
    this.getRoomsThatAreAvailableBetweenDatesService = getRoomsThatAreAvailableBetweenDatesService;
  }

  @GetMapping
  ResponseEntity<List<Room>> findAvailableRooms (
          @PathVariable int roomNumber,
          @RequestBody GetRoomsThatAreAvailableBetweenDatesDTO checkInAndCheckOutTimeData
  ) {
    return new ResponseEntity<>(getRoomsThatAreAvailableBetweenDatesService.findAvaibleRooms(roomNumber, checkInAndCheckOutTimeData.getCheckIn(), checkInAndCheckOutTimeData.getCheckOut()), HttpStatus.OK);
  }
}
