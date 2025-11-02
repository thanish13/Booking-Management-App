package org.t13.app.flights.exceptions;

import org.t13.app.foundation.core.exception.ConflictException;

public class FlightAlreadyExistException extends ConflictException {
    public FlightAlreadyExistException() {
        super("Flight already exists!");
    }
}
