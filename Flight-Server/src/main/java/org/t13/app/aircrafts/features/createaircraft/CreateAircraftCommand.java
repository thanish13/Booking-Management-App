package org.t13.app.aircrafts.features.createaircraft;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.aircrafts.dtos.AircraftDto;

import java.util.UUID;

public record CreateAircraftCommand(
  UUID id,
  String name,
  String model,
  int manufacturingYear
) implements ICommand<AircraftDto>, InternalCommand {
}

