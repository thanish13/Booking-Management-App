package org.t13.app.bookings.exceptions;


import org.t13.app.foundation.core.exception.NotFoundException;

public class SeatNumberIsNotAvailableException extends NotFoundException {
    public SeatNumberIsNotAvailableException() {
        super("SeatNumber is not available!");
    }
}

