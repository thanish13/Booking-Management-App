package org.t13.app.aircrafts.features.createaircraft;



import org.t13.app.foundation.core.event.InternalCommand;
import org.t13.app.foundation.mediator.abstractions.commands.ICommand;
import org.t13.app.foundation.mediator.abstractions.requests.Unit;

import java.util.UUID;

public record CreateAircraftMongoCommand(
  UUID id,
  String name,
  String model,
  int manufacturingYear,
  boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}

