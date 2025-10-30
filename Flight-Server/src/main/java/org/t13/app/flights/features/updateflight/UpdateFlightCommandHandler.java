package org.t13.app.flights.features.updateflight;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.aircrafts.valueobjects.AircraftId;
import org.t13.app.airports.valueobjects.AirportId;
import org.t13.app.data.jpa.entities.FlightEntity;
import org.t13.app.data.jpa.repositories.FlightRepository;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.exceptions.FlightNotFoundException;
import org.t13.app.flights.features.Mappings;
import org.t13.app.flights.models.Flight;
import io.bookingmicroservices.flight.flights.valueobjects.*;
import org.springframework.stereotype.Service;
import org.t13.app.flights.valueobjects.*;

@Service
public class UpdateFlightCommandHandler implements ICommandHandler<UpdateFlightCommand, FlightDto> {
  private final FlightRepository flightRepository;

  public UpdateFlightCommandHandler(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public FlightDto handle(UpdateFlightCommand command) {

    FlightEntity existingFlight = flightRepository.findFlightByIdAndIsDeletedFalse(command.id());
    if (existingFlight == null) {
      throw new FlightNotFoundException();
    }

    Flight flight = Mappings.toFlightAggregate(existingFlight);

    flight.update(new FlightId(existingFlight.getId()), new FlightNumber(command.flightNumber()), new AircraftId(command.aircraftId()), new AirportId(command.departureAirportId()), new DepartureDate(command.departureDate()),
      new ArriveDate(command.arriveDate()), new AirportId(command.arriveAirportId()), new DurationMinutes(command.durationMinutes()), new FlightDate(command.flightDate()),
      command.status(), new Price(command.price()), command.isDeleted());

    FlightEntity flightEntity = Mappings.toFlightEntity(flight);

    FlightEntity updatedFlight = flightRepository.save(flightEntity);
    return Mappings.toFlightDto(updatedFlight);
  }
}
