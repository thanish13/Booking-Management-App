package org.t13.app.airports.features.createairport;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.airports.dtos.AirportDto;
import java.util.UUID;

public record CreateAirportCommand(
  UUID id,
  String name,
  String code,
  String address
  ) implements ICommand<AirportDto>, InternalCommand {
}

