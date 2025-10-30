package org.t13.app.seats.features.getavailableseats;

import org.t13.app.mediator.abstractions.queries.IQuery;
import org.t13.app.seats.dtos.SeatDto;
import java.util.List;
import java.util.UUID;


public record GetAvailableSeatsQuery(
  UUID flightId
) implements IQuery<List<SeatDto>> {
}


