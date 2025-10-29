package org.t13.app;

import org.springframework.stereotype.Component;
import org.t13.app.bookings.features.createbooking.BookingCreatedDomainEvent;
import org.t13.app.bookings.features.createbooking.CreateBookingMongoCommand;
import org.t13.app.contracts.booking.BookingCreated;
import org.t13.app.core.event.DomainEvent;
import org.t13.app.core.event.EventMapper;
import org.t13.app.core.event.IntegrationEvent;
import org.t13.app.core.event.InternalCommand;

@Component
public class EventMapperImpl implements EventMapper {

    @Override
    public IntegrationEvent MapToIntegrationEvent(DomainEvent event) {
        return switch (event) {
            case BookingCreatedDomainEvent e -> new BookingCreated(e.id());
            default -> null;
        };
    }

    @Override
    public InternalCommand MapToInternalCommand(DomainEvent event) {
        return switch (event) {
           case BookingCreatedDomainEvent e -> new CreateBookingMongoCommand(e.id(), e.passengerInfo(), e.trip(), e.isDeleted());
            default -> null;
        };
    }
}

