package org.t13.app.airports.features.createairport;

import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;
import org.t13.app.mediator.abstractions.requests.Unit;
import java.util.UUID;

public record CreateAirportMongoCommand(
  UUID id,
  String name,
  String code,
  String address,
  boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}
