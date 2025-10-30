package org.t13.app.seats.features.createseat;

import org.t13.app.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.mediator.abstractions.requests.Unit;
import org.t13.app.data.mongo.documents.SeatDocument;
import org.t13.app.data.mongo.repositories.SeatReadRepository;
import org.t13.app.seats.exceptions.SeatAlreadyExistException;
import org.t13.app.seats.features.Mappings;
import org.springframework.stereotype.Service;


@Service
public class CreateSeatMongoCommandHandler implements ICommandHandler<CreateSeatMongoCommand, Unit> {

  private final SeatReadRepository seatReadRepository;

  public CreateSeatMongoCommandHandler(SeatReadRepository seatReadRepository) {
    this.seatReadRepository = seatReadRepository;
  }

  public Unit handle(CreateSeatMongoCommand command) {

    SeatDocument seatDocument = Mappings.toSeatDocument(command);

    var seatExist = seatReadRepository.findSeatByFlightIdAndSeatNumberAndIsDeletedFalse(seatDocument.getFlightId(), seatDocument.getSeatNumber());

    if (seatExist != null) {
      throw new SeatAlreadyExistException();
    }

    seatReadRepository.save(seatDocument);

    return Unit.VALUE;
  }
}

