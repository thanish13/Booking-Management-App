package org.t13.app.flights.features.deleteflight;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import buildingblocks.mediator.abstractions.requests.Unit;
import org.t13.app.flights.enums.FlightStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public record DeleteFlightMongoCommand(
  UUID id,
  String flightNumber,
  UUID aircraftId,
  UUID departureAirportId,
  LocalDateTime departureDate,
  LocalDateTime arriveDate,
  UUID arriveAirportId,
  BigDecimal durationMinutes,
  LocalDateTime flightDate,
  FlightStatus status,
  BigDecimal price,
  boolean isDeleted) implements ICommand<Unit>, InternalCommand {
}

