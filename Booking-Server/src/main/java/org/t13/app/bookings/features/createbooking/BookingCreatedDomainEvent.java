package org.t13.app.bookings.features.createbooking;


import org.t13.app.bookings.valueobjects.PassengerInfo;
import org.t13.app.bookings.valueobjects.Trip;
import org.t13.app.core.event.DomainEvent;

import java.util.UUID;


public record BookingCreatedDomainEvent(
        UUID id,
        PassengerInfo passengerInfo,
        Trip trip,
        boolean isDeleted) implements DomainEvent {
}
