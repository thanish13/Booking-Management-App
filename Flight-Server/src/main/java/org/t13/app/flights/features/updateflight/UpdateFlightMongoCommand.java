package org.t13.app.flights.features.updateflight;

import org.t13.app.core.event.InternalCommand;
import org.t13.app.mediator.abstractions.commands.ICommand;
import org.t13.app.mediator.abstractions.requests.Unit;
import org.t13.app.flights.enums.FlightStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public record UpdateFlightMongoCommand(
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

