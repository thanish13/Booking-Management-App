package org.t13.app.aircrafts.features.createaircraft;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import org.t13.app.aircrafts.exceptions.AircraftAlreadyExistException;
import org.t13.app.aircrafts.features.Mappings;
import org.t13.app.data.mongo.documents.AircraftDocument;
import org.t13.app.data.mongo.repositories.AircraftReadRepository;
import org.springframework.stereotype.Service;


@Service
public class CreateAircraftMongoCommandHandler implements ICommandHandler<CreateAircraftMongoCommand, Unit> {

  private final AircraftReadRepository aircraftReadRepository;

  public CreateAircraftMongoCommandHandler(AircraftReadRepository aircraftReadRepository) {
    this.aircraftReadRepository = aircraftReadRepository;
  }

  public Unit handle(CreateAircraftMongoCommand command) {

    AircraftDocument aircraftDocument = Mappings.toAircraftDocument(command);

    var aircraftExist = aircraftReadRepository.findByAircraftIdAndIsDeletedFalse(aircraftDocument.getAircraftId());

    if (aircraftExist != null) {
      throw new AircraftAlreadyExistException();
    }

    aircraftReadRepository.save(aircraftDocument);

    return Unit.VALUE;
  }
}

