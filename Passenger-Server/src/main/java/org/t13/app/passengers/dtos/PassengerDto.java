package org.t13.app.passengers.dtos;

import org.t13.app.passengers.enums.PassengerType;

import java.util.UUID;

public record PassengerDto(
        UUID id,
        String name,
        String passportNumber,
        PassengerType passengerType,
        int age
) { }