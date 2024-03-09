package com.medeiros.reservation.controllers.room;

import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.services.room.SearchForRoomDetailsByNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/room/search-details/{roomNumber}")
public class SearchForRoomDetailsByNumberController {

  private final SearchForRoomDetailsByNumber searchForRoomDetailsByNumberService;

  public SearchForRoomDetailsByNumberController(SearchForRoomDetailsByNumber searchForRoomDetailsByNumberService) {
    this.searchForRoomDetailsByNumberService = searchForRoomDetailsByNumberService;
  }

  @GetMapping
  ResponseEntity<Room> searchForRoomDetails(@PathVariable int roomNumber) {
    return new ResponseEntity<>(searchForRoomDetailsByNumberService.findRoomDetailsByNumber(roomNumber), HttpStatus.OK);
  }
}
