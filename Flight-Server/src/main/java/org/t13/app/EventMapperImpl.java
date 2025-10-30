package org.t13.app;

import org.t13.app.contracts.flight.*;
import org.t13.app.core.event.EventMapper;
import org.t13.app.core.event.DomainEvent;
import org.t13.app.core.event.IntegrationEvent;
import org.t13.app.core.event.InternalCommand;
import org.t13.app.aircrafts.features.createaircraft.AircraftCreatedDomainEvent;
import org.t13.app.aircrafts.features.createaircraft.CreateAircraftMongoCommand;
import org.t13.app.airports.features.createairport.AirportCreatedDomainEvent;
import org.t13.app.airports.features.createairport.CreateAirportMongoCommand;
import org.t13.app.flights.features.createflight.CreateFlightMongoCommand;
import org.t13.app.flights.features.createflight.FlightCreatedDomainEvent;
import org.t13.app.flights.features.deleteflight.DeleteFlightMongoCommand;
import org.t13.app.flights.features.deleteflight.FlightDeletedDomainEvent;
import org.t13.app.flights.features.updateflight.FlightUpdatedDomainEvent;
import org.t13.app.flights.features.updateflight.UpdateFlightMongoCommand;
import org.t13.app.seats.features.createseat.CreateSeatMongoCommand;
import org.t13.app.seats.features.createseat.SeatCreatedDomainEvent;
import org.t13.app.seats.features.reserveseat.ReserveSeatMongoCommand;
import org.t13.app.seats.features.reserveseat.SeatReservedDomainEvent;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

@Component
public class EventMapperImpl implements EventMapper {
  @Override
  public IntegrationEvent MapToIntegrationEvent(@NotNull DomainEvent event) {
      return switch (event) {
        case FlightCreatedDomainEvent e -> new FlightCreated(e.id());
        case FlightUpdatedDomainEvent e -> new FlightUpdated(e.id());
        case FlightDeletedDomainEvent e -> new FlightDeleted(e.id());
        case AirportCreatedDomainEvent e -> new AirportCreated(e.id());
        case AircraftCreatedDomainEvent e -> new AircraftCreated(e.id());
        case SeatCreatedDomainEvent e -> new SeatCreated(e.id());
        case SeatReservedDomainEvent e -> new SeatReserved(e.id());
        default -> null;
      };
  }

  @Override
  public InternalCommand MapToInternalCommand(DomainEvent event) {
    return switch (event) {
      case FlightCreatedDomainEvent e -> new CreateFlightMongoCommand(e.id(), e.flightNumber(), e.aircraftId(), e.departureAirportId(),
        e.departureDate(), e.arriveDate(), e.arriveAirportId(), e.durationMinutes(), e.flightDate(), e.status(), e.price(), e.isDeleted());
      case FlightUpdatedDomainEvent e -> new UpdateFlightMongoCommand(e.id(), e.flightNumber(), e.aircraftId(), e.departureAirportId(),
        e.departureDate(), e.arriveDate(), e.arriveAirportId(), e.durationMinutes(), e.flightDate(), e.status(), e.price(), e.isDeleted());
      case FlightDeletedDomainEvent e -> new DeleteFlightMongoCommand(e.id(), e.flightNumber(), e.aircraftId(), e.departureAirportId(),
        e.departureDate(), e.arriveDate(), e.arriveAirportId(), e.durationMinutes(), e.flightDate(), e.status(), e.price(), e.isDeleted());
      case AirportCreatedDomainEvent e -> new CreateAirportMongoCommand(e.id(), e.name(), e.code(), e.address(), e.isDeleted());
      case AircraftCreatedDomainEvent e -> new CreateAircraftMongoCommand(e.id(), e.name(), e.model(), e.manufacturingYear(), e.isDeleted());
      case SeatCreatedDomainEvent e -> new CreateSeatMongoCommand(e.id(), e.seatNumber(), e.seatType(), e.seatClass(), e.flightId(), e.isDeleted());
      case SeatReservedDomainEvent e -> new ReserveSeatMongoCommand(e.id(), e.seatNumber(), e.seatType(), e.seatClass(), e.flightId(), e.isDeleted());
      default -> null;
    };
  }
}
