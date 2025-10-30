package org.t13.app.seats.features.reserveseat;

import org.t13.app.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.mediator.abstractions.requests.Unit;
import org.t13.app.data.mongo.documents.SeatDocument;
import org.t13.app.data.mongo.repositories.SeatReadRepository;
import org.t13.app.seats.exceptions.SeatNumberAlreadyReservedException;
import org.t13.app.seats.features.Mappings;
import org.springframework.stereotype.Service;

@Service
public class ReserveSeatMongoCommandHandler implements ICommandHandler<ReserveSeatMongoCommand, Unit> {
  private final SeatReadRepository seatReadRepository;

  public ReserveSeatMongoCommandHandler(SeatReadRepository seatReadRepository) {
    this.seatReadRepository = seatReadRepository;
  }

  @Override
  public Unit handle(ReserveSeatMongoCommand command) {
    SeatDocument existSeat = seatReadRepository.findSeatByFlightIdAndSeatNumberAndIsDeletedFalse(command.flightId(), command.seatNumber());

    if (existSeat == null) {
      throw new SeatNumberAlreadyReservedException();
    }

    SeatDocument reservedSeatDocument = Mappings.toReserveSeatDocument(existSeat);
    seatReadRepository.save(reservedSeatDocument);

    return Unit.VALUE;
  }
}
