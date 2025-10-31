package org.t13.app.passengers.features.createpassenger;

import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;
import com.github.f4b6a3.uuid.UuidCreator;
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

