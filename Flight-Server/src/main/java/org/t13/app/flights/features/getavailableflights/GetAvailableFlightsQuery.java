package org.t13.app.flights.features.getavailableflights;

import buildingblocks.mediator.abstractions.queries.IQuery;
import org.t13.app.flights.dtos.FlightDto;
import java.util.List;

public record GetAvailableFlightsQuery() implements IQuery<List<FlightDto>> {
}


