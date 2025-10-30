package org.t13.app.airports.exceptions;

import org.t13.app.core.exception.ConflictException;

public class AirportAlreadyExistException extends ConflictException {
  public AirportAlreadyExistException() {
    super("Airport already exists!");
  }
}
