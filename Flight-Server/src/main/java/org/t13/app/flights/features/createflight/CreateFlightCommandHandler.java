package org.t13.app.flights.features.createflight;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.aircrafts.valueobjects.AircraftId;
import org.t13.app.airports.valueobjects.AirportId;
import org.t13.app.data.jpa.entities.FlightEntity;
import org.t13.app.data.jpa.repositories.FlightRepository;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.exceptions.FlightAlreadyExistException;
import org.t13.app.flights.features.Mappings;
import org.t13.app.flights.models.Flight;
import io.bookingmicroservices.flight.flights.valueobjects.*;
import org.springframework.stereotype.Service;
import org.t13.app.flights.valueobjects.*;

@Service
public class CreateFlightCommandHandler implements ICommandHandler<CreateFlightCommand, FlightDto> {
  private final FlightRepository flightRepository;

  public CreateFlightCommandHandler(
    FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public FlightDto handle(CreateFlightCommand command) {

    FlightEntity existFlight = flightRepository.findFlightByIdAndIsDeletedFalse(command.id());
    if (existFlight!= null) {
      throw new FlightAlreadyExistException();
    }

    Flight flight = Flight.create(
      new FlightId(command.id()),
      new FlightNumber(command.flightNumber()),
      new AircraftId(command.aircraftId()),
      new AirportId(command.departureAirportId()),
      new DepartureDate(command.departureDate()),
      new ArriveDate(command.arriveDate()),
      new AirportId(command.arriveAirportId()),
      new DurationMinutes(command.durationMinutes()),
      new FlightDate(command.flightDate()),
      command.status(),
      new Price(command.price())
    );

    FlightEntity flightEntity = Mappings.toFlightEntity(flight);

    FlightEntity flightCreated = flightRepository.save(flightEntity);
    return Mappings.toFlightDto(flightCreated);
  }
}
