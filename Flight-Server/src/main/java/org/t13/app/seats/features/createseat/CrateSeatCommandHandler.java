package org.t13.app.seats.features.createseat;

import org.t13.app.foundation.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.data.jpa.entities.SeatEntity;
import org.t13.app.data.jpa.repositories.SeatRepository;
import org.t13.app.seats.dtos.SeatDto;
import org.t13.app.seats.exceptions.SeatAlreadyExistException;
import org.t13.app.seats.features.Mappings;
import org.t13.app.seats.models.Seat;
import org.t13.app.seats.valueobjects.FlightId;
import org.t13.app.seats.valueobjects.SeatId;
import org.t13.app.seats.valueobjects.SeatNumber;
import org.springframework.stereotype.Service;

@Service
public class CrateSeatCommandHandler implements ICommandHandler<CreateSeatCommand, SeatDto> {

  private final SeatRepository seatRepository;

  public CrateSeatCommandHandler(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public SeatDto handle(CreateSeatCommand command) {

    SeatEntity existSeat = seatRepository.findSeatByIdAndIsDeletedFalse(command.id());
    if (existSeat!= null) {
      throw new SeatAlreadyExistException();
    }

    Seat seat = Seat.create(
      new SeatId(command.id()),
      new SeatNumber(command.seatNumber()),
      command.seatType(),
      command.seatClass(),
      new FlightId(command.flightId())
    );

    SeatEntity seatEntity = Mappings.toSeatEntity(seat);

    SeatEntity seatCreated = seatRepository.save(seatEntity);
    return Mappings.toSeatDto(seatCreated);
  }
}
