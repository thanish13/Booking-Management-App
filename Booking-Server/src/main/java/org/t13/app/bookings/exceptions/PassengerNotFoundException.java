package org.t13.app.bookings.exceptions;


import org.t13.app.foundation.core.exception.NotFoundException;

public class PassengerNotFoundException extends NotFoundException {
    public PassengerNotFoundException() {
        super("Passenger not found!");
    }
}
