package org.t13.app.seats.features.createseat;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.seats.dtos.SeatDto;
import org.t13.app.seats.enums.SeatClass;
import org.t13.app.seats.enums.SeatType;

import java.util.UUID;

public record CreateSeatCommand(
  UUID id,
  String seatNumber,
  SeatType seatType,
  SeatClass seatClass,
  UUID flightId
) implements ICommand<SeatDto>, InternalCommand {
}


