package org.t13.app.foundation.contracts.booking;


import org.t13.app.foundation.core.event.IntegrationEvent;

import java.util.UUID;

public record BookingCreated(UUID Id) implements IntegrationEvent {
}

