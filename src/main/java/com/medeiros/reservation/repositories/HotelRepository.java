package com.medeiros.reservation.repositories;

import com.medeiros.reservation.entities.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
  Hotel findByName(String name);
}
