package org.t13.app.flights.features.deleteflight;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.flights.dtos.FlightDto;
import java.util.UUID;

public record DeleteFlightCommand(
  UUID id
) implements ICommand<FlightDto>, InternalCommand {
}

