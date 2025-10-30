package org.t13.app.aircrafts.exceptions;


import org.t13.app.core.exception.ConflictException;

public class AircraftAlreadyExistException extends ConflictException {
  public AircraftAlreadyExistException() {
    super("Aircraft already exists!");
  }
}

