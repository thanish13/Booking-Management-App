package org.t13.app.flights.features.deleteflight;

import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;
import org.t13.app.flights.dtos.FlightDto;
import java.util.UUID;

public record DeleteFlightCommand(
  UUID id
) implements ICommand<FlightDto>, InternalCommand {
}

