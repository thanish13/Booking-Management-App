package org.t13.app.aircrafts.features.createaircraft;

import org.t13.app.aircrafts.dtos.AircraftDto;
import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;

import java.util.UUID;

public record CreateAircraftCommand(
  UUID id,
  String name,
  String model,
  int manufacturingYear
) implements ICommand<AircraftDto>, InternalCommand {
}

