package org.t13.app.seats.exceptions;

import org.t13.app.core.exception.ConflictException;

public class SeatAlreadyExistException extends ConflictException {
  public SeatAlreadyExistException() {
    super("Seat already exists!");
  }
}

