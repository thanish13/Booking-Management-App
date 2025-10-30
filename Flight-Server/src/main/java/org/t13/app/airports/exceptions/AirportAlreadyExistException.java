package org.t13.app.airports.exceptions;

import buildingblocks.core.exception.ConflictException;

public class AirportAlreadyExistException extends ConflictException {
  public AirportAlreadyExistException() {
    super("Airport already exists!");
  }
}
