package br.com.medeiros.hotelreservation.controllers.room;

import br.com.medeiros.hotelreservation.dtos.RegisterHotelRoomDTO;
import br.com.medeiros.hotelreservation.entities.room.Room;
import br.com.medeiros.hotelreservation.usecases.room.RegisterRoom;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/room/register")
public class RegisterRoomController {

  private final RegisterRoom registerRoomService;

  public RegisterRoomController(RegisterRoom registerRoomService) {
    this.registerRoomService = registerRoomService;
  }

  @PostMapping
  ResponseEntity<Room> registerRoom(@RequestBody @Valid RegisterHotelRoomDTO roomDataRequest) {
    return new ResponseEntity<>(registerRoomService.register(roomDataRequest), HttpStatus.CREATED);
  }
}
