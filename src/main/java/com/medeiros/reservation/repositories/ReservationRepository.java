package com.medeiros.reservation.repositories;

import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, UUID> {
  Reservation findReservationByCustomer(Customer customer);

  List<Reservation> findReservationsByRoomAndCheckOutAfterAndCheckInBefore (
          Room room,
          LocalDateTime checkIn,
          LocalDateTime checkOut
  );

  List<Reservation> findReservationsByRoomAndCheckInBetweenOrCheckOutBetween (
          Room room,
          LocalDateTime checkInStart,
          LocalDateTime checkInEnd,
          LocalDateTime checkOutStart,
          LocalDateTime checkOutEnd
  );
}

