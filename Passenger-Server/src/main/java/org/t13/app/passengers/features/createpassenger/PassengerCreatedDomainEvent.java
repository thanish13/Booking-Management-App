package org.t13.app.passengers.features.createpassenger;

import org.t13.app.foundation.core.event.DomainEvent;
import org.t13.app.passengers.enums.PassengerType;

import java.util.UUID;

public record PassengerCreatedDomainEvent(
        UUID id,
        String name,
        String passportNumber,
        PassengerType passengerType,
        int age,
        boolean isDeleted) implements DomainEvent {
}