package org.t13.app.passengers.features.getpassengerbyid;

import org.t13.app.data.mongo.documents.PassengerDocument;
import org.t13.app.data.mongo.repositories.PassengerReadRepository;
import org.t13.app.mediator.abstractions.queries.IQueryHandler;
import org.springframework.stereotype.Service;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.features.Mappings;

@Service
public class GetPassengerByIdQueryHandler implements IQueryHandler<GetPassengerByIdQuery, PassengerDto> {
    private final PassengerReadRepository passengerReadRepository;

    public GetPassengerByIdQueryHandler(PassengerReadRepository passengerReadRepository) {
        this.passengerReadRepository = passengerReadRepository;
    }

    @Override
    public PassengerDto handle(GetPassengerByIdQuery query) {
        PassengerDocument passenger = passengerReadRepository.findPassengerByPassengerIdAndIsDeletedFalse(query.id());
        return Mappings.toPassengerDto(passenger);
    }
}
