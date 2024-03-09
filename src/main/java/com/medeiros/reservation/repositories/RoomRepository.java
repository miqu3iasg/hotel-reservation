package com.medeiros.reservation.repositories;

import com.medeiros.reservation.entities.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<Room, UUID> {
  Optional<Room> findByNumber(int number);
}
