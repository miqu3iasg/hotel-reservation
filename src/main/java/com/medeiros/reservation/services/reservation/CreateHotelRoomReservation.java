package br.com.medeiros.hotelreservation.usecases.reservation;

import br.com.medeiros.hotelreservation.dtos.CreateHotelRoomReservationDTO;
import br.com.medeiros.hotelreservation.entities.customer.Customer;
import br.com.medeiros.hotelreservation.entities.reservation.Reservation;
import br.com.medeiros.hotelreservation.entities.reservation.ReservationStatus;
import br.com.medeiros.hotelreservation.entities.room.Room;
import br.com.medeiros.hotelreservation.exceptions.CustomerNotFoundException;
import br.com.medeiros.hotelreservation.exceptions.RoomNotFoundException;
import br.com.medeiros.hotelreservation.repositories.CustomerRepository;
import br.com.medeiros.hotelreservation.repositories.ReservationRepository;
import br.com.medeiros.hotelreservation.repositories.RoomRepository;
import br.com.medeiros.hotelreservation.utils.TimeProvider;
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
