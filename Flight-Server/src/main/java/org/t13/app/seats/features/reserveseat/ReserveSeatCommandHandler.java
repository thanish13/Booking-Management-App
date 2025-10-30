package org.t13.app.seats.features.reserveseat;

import buildingblocks.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.data.jpa.entities.SeatEntity;
import org.t13.app.data.jpa.repositories.SeatRepository;
import org.t13.app.seats.dtos.SeatDto;
import org.t13.app.seats.exceptions.SeatNumberAlreadyReservedException;
import org.t13.app.seats.features.Mappings;
import org.t13.app.seats.models.Seat;
import org.t13.app.seats.valueobjects.FlightId;
import org.t13.app.seats.valueobjects.SeatNumber;
import org.springframework.stereotype.Service;


@Service
public class ReserveSeatCommandHandler implements ICommandHandler<ReserveSeatCommand, SeatDto> {
  private final SeatRepository seatRepository;

  public ReserveSeatCommandHandler(SeatRepository seatRepository) {
    this.seatRepository = seatRepository;
  }

  @Override
  public SeatDto handle(ReserveSeatCommand command) {
    SeatEntity existSeat = seatRepository.findSeatByFlightIdAndSeatNumberAndIsDeletedFalse(new FlightId(command.flightId()), new SeatNumber(command.seatNumber()));

    if (existSeat == null) {
         throw new SeatNumberAlreadyReservedException();
    }

    Seat seat = Mappings.toSeatAggregate(existSeat);

    seat.reserveSeat();

    SeatEntity seatEntity = Mappings.toSeatEntity(seat);
    SeatEntity seatUpdated = seatRepository.save(seatEntity);

    return Mappings.toSeatDto(seatUpdated);
  }
}
