package org.t13.app.aircrafts.exceptions;


import org.t13.app.foundation.core.exception.ConflictException;

public class AircraftAlreadyExistException extends ConflictException {
  public AircraftAlreadyExistException() {
    super("Aircraft already exists!");
  }
}

