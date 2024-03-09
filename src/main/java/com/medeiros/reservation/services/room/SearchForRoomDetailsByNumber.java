package br.com.medeiros.hotelreservation.usecases.room;

import br.com.medeiros.hotelreservation.entities.room.Room;
import br.com.medeiros.hotelreservation.exceptions.RoomNotFoundException;
import br.com.medeiros.hotelreservation.repositories.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class SearchForRoomDetailsByNumber {
  private final RoomRepository roomRepository;

  public SearchForRoomDetailsByNumber(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
  }

  public Room findRoomDetailsByNumber(int roomNumber) {
    return roomRepository.findByNumber(roomNumber)
            .orElseThrow(RoomNotFoundException::new);
  }
}
