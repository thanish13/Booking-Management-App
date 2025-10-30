package org.t13.app.aircrafts.features.createaircraft;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.requests.Unit;

import java.util.UUID;

public record CreateAircraftMongoCommand(
  UUID id,
  String name,
  String model,
  int manufacturingYear,
  boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}

