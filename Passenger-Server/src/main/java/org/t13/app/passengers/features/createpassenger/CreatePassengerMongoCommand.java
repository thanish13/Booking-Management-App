package org.t13.app.passengers.features.createpassenger;

import org.t13.app.foundation.core.event.InternalCommand;
import org.t13.app.foundation.mediator.abstractions.commands.ICommand;
import org.t13.app.foundation.mediator.abstractions.requests.Unit;
import org.t13.app.passengers.enums.PassengerType;

import java.util.UUID;

public record CreatePassengerMongoCommand(
        UUID id,
        String name,
        String passportNumber,
        PassengerType passengerType,
        int age,
        boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}
