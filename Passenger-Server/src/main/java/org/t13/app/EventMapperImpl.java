package org.t13.app;

import org.t13.app.contracts.passenger.PassengerCreated;
import org.t13.app.core.event.DomainEvent;
import org.t13.app.core.event.EventMapper;
import org.t13.app.core.event.IntegrationEvent;
import org.t13.app.core.event.InternalCommand;
import org.springframework.stereotype.Component;
import org.t13.app.passengers.features.createpassenger.CreatePassengerMongoCommand;
import org.t13.app.passengers.features.createpassenger.PassengerCreatedDomainEvent;

@Component
public class EventMapperImpl implements EventMapper {
    @Override
    public IntegrationEvent MapToIntegrationEvent(DomainEvent event) {
        return switch (event) {
            case PassengerCreatedDomainEvent e -> new PassengerCreated(e.id());
            default -> null;
        };
    }

    @Override
    public InternalCommand MapToInternalCommand(DomainEvent event) {
        return switch (event) {
            case PassengerCreatedDomainEvent e -> new CreatePassengerMongoCommand(e.id(), e.name(), e.passportNumber(), e.passengerType(), e.age(), e.isDeleted());
            default -> null;
        };
    }
}
