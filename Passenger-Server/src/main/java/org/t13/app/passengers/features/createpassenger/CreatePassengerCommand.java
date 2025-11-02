package org.t13.app.passengers.features.createpassenger;

import org.t13.app.foundation.core.event.InternalCommand;
import org.t13.app.foundation.mediator.abstractions.commands.ICommand;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.enums.PassengerType;


import java.util.UUID;

public record CreatePassengerCommand(
        UUID id,
        String name,
        String passportNumber,
        PassengerType passengerType,
        int age
) implements ICommand<PassengerDto>, InternalCommand {
    public CreatePassengerCommand {
    }
}

