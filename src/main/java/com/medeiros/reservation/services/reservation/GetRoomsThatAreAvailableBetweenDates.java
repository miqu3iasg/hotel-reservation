package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.exceptions.room.RoomNotFoundException;
import com.medeiros.reservation.repositories.ReservationRepository;
import com.medeiros.reservation.repositories.RoomRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GetRoomsThatAreAvailableBetweenDates {
  private final ReservationRepository reservationRepository;
  private final RoomRepository roomRepository;

  public GetRoomsThatAreAvailableBetweenDates(
          ReservationRepository reservationRepository,
          RoomRepository roomRepository
  ) {
    this.reservationRepository = reservationRepository;
    this.roomRepository = roomRepository;
  }

  public List<Room> findAvaibleRooms(int roomNumber, LocalDateTime checkIn, LocalDateTime checkOut) {
    Room roomFound = validateIfRoomExistsByRoomNumber(roomNumber);

    List<Reservation> overlappingReservations = getOverlappingReservations(roomFound, checkIn, checkOut);

    if (overlappingReservations.isEmpty()) return getAllRooms();

    else return findAvailableRoomsFromAllRooms(overlappingReservations);
  }

  private Room validateIfRoomExistsByRoomNumber(int roomNumber) {
    return roomRepository.findByNumber(roomNumber)
            .orElseThrow(RoomNotFoundException::new);
  }

  private List<Reservation> getOverlappingReservations(Room room, LocalDateTime checkIn, LocalDateTime checkOut) {
    return reservationRepository.findReservationsByRoomAndCheckOutAfterAndCheckInBefore (
            room,
            checkIn,
            checkOut
    );
  }

  private List<Room>  getAllRooms() {
    return roomRepository.findAll();
  }

  private List<Room> findAvailableRoomsFromAllRooms(List<Reservation> overlappingReservations) {
    List<Room> allRooms = getAllRooms();
    List<Room> occupiedRooms = getOccupiedRooms(overlappingReservations);
    return findAvailableRooms(allRooms, occupiedRooms);
  }

  private List<Room> getOccupiedRooms(List<Reservation> overlappingReservations) {
    return overlappingReservations.stream()
            .map(Reservation::getRoom)
            .filter(room -> !room.isAvailability())
            .collect(Collectors.toList());
  }

  private List<Room> findAvailableRooms(List<Room> allRooms, List<Room> occupiedRooms) {
    return allRooms.stream()
            .filter(room -> !occupiedRooms.contains(room) && room.isAvailability())
            .collect(Collectors.toList());
  }
}

