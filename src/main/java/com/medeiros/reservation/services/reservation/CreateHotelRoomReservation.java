package com.medeiros.reservation.services.reservation;

import com.medeiros.reservation.dtos.room.CreateHotelRoomReservationDTO;

import com.medeiros.reservation.entities.customer.Customer;
import com.medeiros.reservation.entities.reservation.Reservation;
import com.medeiros.reservation.entities.reservation.ReservationStatus;
import com.medeiros.reservation.entities.room.Room;
import com.medeiros.reservation.exceptions.customer.CustomerNotFoundException;
import com.medeiros.reservation.exceptions.room.RoomNotFoundException;
import com.medeiros.reservation.repositories.CustomerRepository;
import com.medeiros.reservation.repositories.ReservationRepository;
import com.medeiros.reservation.repositories.RoomRepository;
import com.medeiros.reservation.utils.TimeProvider;
import org.springframework.stereotype.Service;

@Service
public class CreateHotelRoomReservation {

  private final RoomRepository roomRepository;
  private final CustomerRepository customerRepository;
  private final ReservationRepository reservationRepository;

  public CreateHotelRoomReservation(
          RoomRepository roomRepository,
          CustomerRepository customerRepository,
          ReservationRepository reservationRepository
  ) {
    this.roomRepository = roomRepository;
    this.customerRepository = customerRepository;
    this.reservationRepository = reservationRepository;
  }

  public Reservation createReservation(CreateHotelRoomReservationDTO reservationDataRequest) {
    Customer customerFound = findCustomerByEmail(reservationDataRequest.getCustomerEmail());

    Room roomFound = findRoomByNumber(reservationDataRequest.getHotelRoomNumber());

    checkRoomAvailability(roomFound);

    Reservation reservation = createReservationFromRequest(customerFound, roomFound);

    updateRoomAvailability(roomFound);

    return reservationRepository.save(reservation);
  }

  private Customer findCustomerByEmail(String email) {
    return customerRepository.findByEmail(email)
            .orElseThrow(() -> new CustomerNotFoundException("Customer not found with email: " + email));
  }

  private Room findRoomByNumber(int roomNumber) {
    return roomRepository.findByNumber(roomNumber)
            .orElseThrow(() -> new RoomNotFoundException());
  }

  private void checkRoomAvailability(Room room) {
    if (!room.isAvailability()) {
      throw new IllegalStateException("Room is not available");
    }
  }

  private Reservation createReservationFromRequest(Customer customer, Room room) {
    Reservation reservation = new Reservation();

    reservation.setCustomer(customer);
    reservation.setRoom(room);
    reservation.setStatus(ReservationStatus.CONFIRMED);
    reservation.setCheckIn(TimeProvider.getInstance().setCheckInLocalDateTime());
    reservation.setCreatedAt(TimeProvider.getInstance().setLocalDateTime());
    reservation.setUpdatedAt(TimeProvider.getInstance().setLocalDateTime());

    return reservation;
  }

  private void updateRoomAvailability(Room room) {
    room.setAvailability(false);
  }
}
