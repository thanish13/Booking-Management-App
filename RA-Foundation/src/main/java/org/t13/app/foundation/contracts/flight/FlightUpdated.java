package org.t13.app.foundation.contracts.flight;


import org.t13.app.foundation.core.event.IntegrationEvent;
import java.util.UUID;

public record FlightUpdated(UUID Id) implements IntegrationEvent {
}
