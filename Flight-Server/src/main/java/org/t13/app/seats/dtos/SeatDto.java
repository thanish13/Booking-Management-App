package org.t13.app.seats.dtos;

import org.t13.app.seats.enums.SeatClass;
import org.t13.app.seats.enums.SeatType;
import java.util.UUID;

public record SeatDto(
  UUID id,
  String seatNumber,
  SeatType seatType,
  SeatClass seatClass,
  UUID flightId
) { }
