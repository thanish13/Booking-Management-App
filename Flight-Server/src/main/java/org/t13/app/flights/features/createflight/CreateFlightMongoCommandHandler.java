package org.t13.app.flights.features.createflight;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import org.t13.app.data.mongo.documents.FlightDocument;
import org.t13.app.data.mongo.repositories.FlightReadRepository;
import org.t13.app.flights.exceptions.FlightAlreadyExistException;
import org.t13.app.flights.features.Mappings;
import org.springframework.stereotype.Service;


@Service
public class CreateFlightMongoCommandHandler implements ICommandHandler<CreateFlightMongoCommand, Unit> {
  private final FlightReadRepository flightReadRepository;

  public CreateFlightMongoCommandHandler(FlightReadRepository flightReadRepository) {
    this.flightReadRepository = flightReadRepository;
  }

  public Unit handle(CreateFlightMongoCommand command) {

      FlightDocument flightDocument = Mappings.toFlightDocument(command);

      var flightExist = flightReadRepository.findByFlightIdAndIsDeletedFalse(flightDocument.getFlightId());

      if (flightExist != null) {
        throw new FlightAlreadyExistException();
      }

      flightReadRepository.save(flightDocument);

      return Unit.VALUE;
  }
}
