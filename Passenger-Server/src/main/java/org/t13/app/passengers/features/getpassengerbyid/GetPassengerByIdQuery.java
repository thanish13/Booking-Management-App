package org.t13.app.passengers.features.getpassengerbyid;

import org.t13.app.foundation.mediator.abstractions.queries.IQuery;
import org.t13.app.passengers.dtos.PassengerDto;

import java.util.UUID;

public record GetPassengerByIdQuery(
        UUID id
) implements IQuery<PassengerDto> {
}

