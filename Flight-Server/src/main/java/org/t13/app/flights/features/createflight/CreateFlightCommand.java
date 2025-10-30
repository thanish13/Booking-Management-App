package org.t13.app.flights.features.createflight;

import buildingblocks.core.event.InternalCommand;
import buildingblocks.mediator.abstractions.commands.ICommand;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.enums.FlightStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateFlightCommand(
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
  BigDecimal price) implements ICommand<FlightDto>, InternalCommand {
}
