package org.t13.app.bookings.features.createbooking;

import org.t13.app.bookings.dtos.BookingDto;
import org.t13.app.foundation.core.event.InternalCommand;
import org.t13.app.foundation.mediator.abstractions.commands.ICommand;

import java.util.UUID;

public record CreateBookingCommand(
        UUID id,
        UUID passengerId,
        UUID flightId,
        String description
) implements ICommand<BookingDto>, InternalCommand {
}