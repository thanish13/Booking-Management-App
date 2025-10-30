package org.t13.app.flights.features.getavailableflights;

import buildingblocks.mediator.abstractions.queries.IQueryHandler;
import org.t13.app.data.mongo.documents.FlightDocument;
import org.t13.app.data.mongo.repositories.FlightReadRepository;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.features.Mappings;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAvailableFlightsQueryHandler implements IQueryHandler<GetAvailableFlightsQuery, List<FlightDto>> {
  private final FlightReadRepository flightReadRepository;

  public GetAvailableFlightsQueryHandler(FlightReadRepository flightReadRepository) {
    this.flightReadRepository = flightReadRepository;
  }

  @Override
  public List<FlightDto> handle(GetAvailableFlightsQuery query) {
    List<FlightDocument> flightDocuments =  flightReadRepository.findAllByIsDeletedFalse();
    return flightDocuments.stream().map(Mappings::toFlightDto).toList();
  }
}
