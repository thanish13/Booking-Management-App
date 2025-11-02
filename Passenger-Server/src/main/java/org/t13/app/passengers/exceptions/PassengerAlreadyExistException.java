package org.t13.app.passengers.exceptions;

import org.t13.app.foundation.core.exception.ConflictException;

public class PassengerAlreadyExistException extends ConflictException {
    public PassengerAlreadyExistException() {
        super("Passenger already exists!");
    }
}

