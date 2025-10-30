package org.t13.app.flights.features.updateflight;

import org.t13.app.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.mediator.abstractions.requests.Unit;
import org.t13.app.data.mongo.documents.FlightDocument;
import org.t13.app.data.mongo.repositories.FlightReadRepository;
import org.t13.app.flights.exceptions.FlightNotFoundException;
import org.t13.app.flights.features.Mappings;
import org.springframework.stereotype.Service;


@Service
public class UpdateFlightMongoCommandHandler implements ICommandHandler<UpdateFlightMongoCommand, Unit> {

  private final FlightReadRepository flightReadRepository;

  public UpdateFlightMongoCommandHandler(FlightReadRepository flightReadRepository) {
    this.flightReadRepository = flightReadRepository;
  }

  public Unit handle(UpdateFlightMongoCommand command) {

    FlightDocument flight = flightReadRepository.findByFlightIdAndIsDeletedFalse(command.id());

    if (flight == null) {
      throw new FlightNotFoundException();
    }

    FlightDocument flightDocument = Mappings.toFlightDocument(flight.getId(), command);

    flightReadRepository.save(flightDocument);

    return Unit.VALUE;
  }
}

