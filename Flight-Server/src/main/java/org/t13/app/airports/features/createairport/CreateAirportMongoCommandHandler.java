package org.t13.app.airports.features.createairport;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import buildingblocks.mediator.abstractions.requests.Unit;
import org.t13.app.airports.exceptions.AirportAlreadyExistException;
import org.t13.app.airports.features.Mappings;
import org.t13.app.data.mongo.documents.AirportDocument;
import org.t13.app.data.mongo.repositories.AirportReadRepository;
import org.springframework.stereotype.Service;


@Service
public class CreateAirportMongoCommandHandler implements ICommandHandler<CreateAirportMongoCommand, Unit> {

  private final AirportReadRepository airportReadRepository;

  public CreateAirportMongoCommandHandler(AirportReadRepository airportReadRepository) {
    this.airportReadRepository = airportReadRepository;
  }

  public Unit handle(CreateAirportMongoCommand command) {

    AirportDocument airportDocument = Mappings.toAirportDocument(command);

    var airportExist = airportReadRepository.findByAirportIdAndIsDeletedFalse(airportDocument.getAirportId());

    if (airportExist != null) {
      throw new AirportAlreadyExistException();
    }

    airportReadRepository.save(airportDocument);

    return Unit.VALUE;
  }
}

