package org.t13.app.flights.features.getflightbyid;

import buildingblocks.mediator.abstractions.queries.IQuery;
import org.t13.app.flights.dtos.FlightDto;
import java.util.UUID;

public record GetFlightByIdQuery(
  UUID id
) implements IQuery<FlightDto> {
}


