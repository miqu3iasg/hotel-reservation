package com.medeiros.reservation.services.room;

import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.exceptions.room.RoomNotFoundException;
import com.medeiros.reservation.repositories.RoomRepository;
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
