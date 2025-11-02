package org.t13.app.flights.exceptions;

import org.t13.app.foundation.core.exception.NotFoundException;

public class FlightNotFoundException extends NotFoundException {
    public FlightNotFoundException() {
        super("Flight not found!");
    }
}
