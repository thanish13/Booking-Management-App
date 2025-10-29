package org.t13.app.bookings.features.createbooking;


import org.t13.app.bookings.valueobjects.PassengerInfo;
import org.t13.app.bookings.valueobjects.Trip;
import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;
import org.t13.app.mediator.abstractions.requests.Unit;

import java.util.UUID;


public record CreateBookingMongoCommand(
        UUID id,
        PassengerInfo passengerInfo,
        Trip trip,
        boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}

