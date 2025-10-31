package org.t13.app.passengers.exceptions;

import org.t13.app.core.exception.ConflictException;

public class PassengerAlreadyExistException extends ConflictException {
    public PassengerAlreadyExistException() {
        super("Passenger already exists!");
    }
}

