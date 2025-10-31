package org.t13.app.passengers.features.createpassenger;


import org.t13.app.passengers.enums.PassengerType;

public record CreatePassengerRequestDto(
        String name,
        String PassportNumber,
        PassengerType passengerType,
        int age){
}

