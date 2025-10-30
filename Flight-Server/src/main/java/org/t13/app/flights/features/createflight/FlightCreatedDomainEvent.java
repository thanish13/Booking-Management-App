package org.t13.app.flights.features.createflight;

import org.t13.app.core.event.DomainEvent;
import org.t13.app.flights.enums.FlightStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;


public record FlightCreatedDomainEvent(
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
  boolean isDeleted) implements DomainEvent {
}


