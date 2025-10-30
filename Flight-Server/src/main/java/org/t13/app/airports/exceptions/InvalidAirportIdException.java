package org.t13.app.airports.exceptions;

import buildingblocks.core.exception.BadRequestException;

import java.util.UUID;

public class InvalidAirportIdException extends BadRequestException {
    public InvalidAirportIdException(UUID airportId) {
        super("Airport ID: '" + airportId.toString() + "' is invalid.");
    }
}

