package org.t13.app.flights.exceptions;

import org.t13.app.core.exception.ConflictException;

public class FlightAlreadyExistException extends ConflictException {
    public FlightAlreadyExistException() {
        super("Flight already exists!");
    }
}
