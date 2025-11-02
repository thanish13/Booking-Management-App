package org.t13.app;

import org.springframework.stereotype.Component;
import org.t13.app.bookings.features.createbooking.BookingCreatedDomainEvent;
import org.t13.app.bookings.features.createbooking.CreateBookingMongoCommand;
import org.t13.app.foundation.contracts.booking.BookingCreated;
import org.t13.app.foundation.core.event.DomainEvent;
import org.t13.app.foundation.core.event.EventMapper;
import org.t13.app.foundation.core.event.IntegrationEvent;
import org.t13.app.foundation.core.event.InternalCommand;

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

