package org.t13.app.contracts.flight;


import org.t13.app.core.event.IntegrationEvent;

import java.util.UUID;

public record SeatReserved(UUID Id) implements IntegrationEvent {
}

