package org.t13.app.seats.features.reserveseat;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.seats.dtos.SeatDto;
import java.util.UUID;


public record ReserveSeatCommand(
  String seatNumber,
  UUID flightId
) implements ICommand<SeatDto>, InternalCommand {
}

