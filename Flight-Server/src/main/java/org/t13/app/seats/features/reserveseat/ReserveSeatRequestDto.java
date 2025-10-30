package org.t13.app.seats.features.reserveseat;

import java.util.UUID;

public record ReserveSeatRequestDto(
  String seatNumber,
  UUID flightId){
}

