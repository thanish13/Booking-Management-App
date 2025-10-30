package org.t13.app.flights.features.getflightbyid;

import org.t13.app.mediator.abstractions.queries.IQuery;
import org.t13.app.flights.dtos.FlightDto;
import java.util.UUID;

public record GetFlightByIdQuery(
  UUID id
) implements IQuery<FlightDto> {
}


