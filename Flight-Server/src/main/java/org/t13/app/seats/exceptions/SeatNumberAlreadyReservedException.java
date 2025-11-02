package org.t13.app.seats.exceptions;

import org.t13.app.foundation.core.exception.BadRequestException;

public class SeatNumberAlreadyReservedException extends BadRequestException {
  public SeatNumberAlreadyReservedException() {
    super("Seat number already reserved!");
  }
}

