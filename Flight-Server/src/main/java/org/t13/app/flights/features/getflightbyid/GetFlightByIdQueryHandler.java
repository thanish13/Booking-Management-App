package org.t13.app.flights.features.getflightbyid;

import buildingblocks.mediator.abstractions.queries.IQueryHandler;
import org.t13.app.data.mongo.documents.FlightDocument;
import org.t13.app.data.mongo.repositories.FlightReadRepository;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.exceptions.FlightNotFoundException;
import org.t13.app.flights.features.Mappings;
import org.springframework.stereotype.Service;

@Service
public class GetFlightByIdQueryHandler implements IQueryHandler<GetFlightByIdQuery, FlightDto> {
  private final FlightReadRepository flightReadRepository;

  public GetFlightByIdQueryHandler(FlightReadRepository flightReadRepository) {
    this.flightReadRepository = flightReadRepository;
  }

  @Override
  public FlightDto handle(GetFlightByIdQuery query) {
    FlightDocument flightDocument = flightReadRepository.findByFlightIdAndIsDeletedFalse(query.id());

    if (flightDocument == null) {
      throw new FlightNotFoundException();
    }

    return Mappings.toFlightDto(flightDocument);
  }
}
