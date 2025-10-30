package org.t13.app.data.jpa.repositories;

import org.t13.app.data.jpa.entities.SeatEntity;
import org.t13.app.seats.valueobjects.FlightId;
import org.t13.app.seats.valueobjects.SeatNumber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface SeatRepository extends JpaRepository<SeatEntity, UUID> {
  SeatEntity findSeatByIdAndIsDeletedFalse(UUID id);
  SeatEntity findSeatByFlightIdAndSeatNumberAndIsDeletedFalse(FlightId flightId, SeatNumber seatNumber);
}
