package org.t13.app.contracts.booking;


import org.t13.app.core.event.IntegrationEvent;

import java.util.UUID;

public record BookingCreated(UUID Id) implements IntegrationEvent {
}

