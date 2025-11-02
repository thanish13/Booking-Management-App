package org.t13.app.seats.features.getavailableseats;

import org.t13.app.foundation.mediator.abstractions.queries.IQueryHandler;
import org.t13.app.data.mongo.documents.SeatDocument;
import org.t13.app.data.mongo.repositories.SeatReadRepository;
import org.t13.app.seats.dtos.SeatDto;
import org.t13.app.seats.features.Mappings;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GetAvailableSeatsQueryHandler implements IQueryHandler<GetAvailableSeatsQuery, List<SeatDto>> {
  private final SeatReadRepository seatReadRepository;

  public GetAvailableSeatsQueryHandler(SeatReadRepository seatReadRepository) {
    this.seatReadRepository = seatReadRepository;
  }

  @Override
  public List<SeatDto> handle(GetAvailableSeatsQuery query) {
    List<SeatDocument> seats = seatReadRepository.findAllSeatsByFlightIdAndIsDeletedFalse(query.flightId());
    return seats.stream().map(Mappings::toSeatDto).toList();
  }
}

