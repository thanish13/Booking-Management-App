package org.t13.app.bookings.exceptions;

import buildingblocks.core.exception.ConflictException;

public class BookingAlreadyExistException extends ConflictException {
    public BookingAlreadyExistException() {
        super("Booking already exists!");
    }
}

