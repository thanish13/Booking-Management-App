package org.t13.app.flights.features.deleteflight;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import org.t13.app.data.mongo.documents.FlightDocument;
import org.t13.app.data.mongo.repositories.FlightReadRepository;
import org.t13.app.flights.exceptions.FlightNotFoundException;
import org.t13.app.flights.features.Mappings;
import org.springframework.stereotype.Service;


@Service
public class DeleteFlightMongoCommandHandler implements ICommandHandler<DeleteFlightMongoCommand, Unit> {


  private final FlightReadRepository flightReadRepository;

  public DeleteFlightMongoCommandHandler(FlightReadRepository flightReadRepository) {
    this.flightReadRepository = flightReadRepository;
  }

  public Unit handle(DeleteFlightMongoCommand command) {

    FlightDocument flightDocument = Mappings.toFlightDocument(command);

    var flight = flightReadRepository.findByFlightIdAndIsDeletedFalse(flightDocument.getFlightId());

    if (flight == null) {
      throw new FlightNotFoundException();
    }

    flightReadRepository.save(flightDocument);

    return Unit.VALUE;
  }
}

