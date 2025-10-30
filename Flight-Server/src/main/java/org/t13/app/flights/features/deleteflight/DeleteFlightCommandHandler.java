package org.t13.app.flights.features.deleteflight;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.data.jpa.entities.FlightEntity;
import org.t13.app.data.jpa.repositories.FlightRepository;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.exceptions.FlightNotFoundException;
import org.t13.app.flights.features.Mappings;
import org.t13.app.flights.models.Flight;
import org.springframework.stereotype.Component;

@Component
public class DeleteFlightCommandHandler implements ICommandHandler<DeleteFlightCommand, FlightDto> {
  private final FlightRepository flightRepository;

  public DeleteFlightCommandHandler(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public FlightDto handle(DeleteFlightCommand command) {

    FlightEntity existingFlight = flightRepository.findFlightByIdAndIsDeletedFalse(command.id());
    if (existingFlight == null) {
      throw new FlightNotFoundException();
    }

    Flight flight = Mappings.toFlightAggregate(existingFlight);

    flight.delete();

    FlightEntity flightEntity = Mappings.toFlightEntity(flight);

    FlightEntity updatedFlight = flightRepository.save(flightEntity);
    return Mappings.toFlightDto(updatedFlight);
  }
}
