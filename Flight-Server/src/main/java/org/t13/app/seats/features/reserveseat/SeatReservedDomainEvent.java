package org.t13.app.seats.features.reserveseat;

import org.t13.app.core.event.DomainEvent;
import org.t13.app.seats.enums.SeatClass;
import org.t13.app.seats.enums.SeatType;
import java.util.UUID;

public record SeatReservedDomainEvent(
  UUID id,
  String seatNumber,
  SeatType seatType,
  SeatClass seatClass,
  UUID flightId,
  boolean isDeleted) implements DomainEvent {
}

