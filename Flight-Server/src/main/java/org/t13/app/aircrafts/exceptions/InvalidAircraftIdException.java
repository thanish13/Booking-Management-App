package org.t13.app.aircrafts.exceptions;

import org.apache.coyote.BadRequestException;
import java.util.UUID;

public class InvalidAircraftIdException extends BadRequestException {
    public InvalidAircraftIdException(UUID aircraftId) {
        super("Aircraft ID: '" + aircraftId.toString() + "' is invalid.");
    }
}

