package org.t13.app.foundation.contracts.passenger;


import org.t13.app.foundation.core.event.IntegrationEvent;

import java.util.UUID;

public record PassengerCreated(UUID Id) implements IntegrationEvent {
}
