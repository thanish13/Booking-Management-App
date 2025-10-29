package org.t13.app.bookings.exceptions;


import org.t13.app.core.exception.ConflictException;

public class BookingAlreadyExistException extends ConflictException {
    public BookingAlreadyExistException() {
        super("Booking already exists!");
    }
}

