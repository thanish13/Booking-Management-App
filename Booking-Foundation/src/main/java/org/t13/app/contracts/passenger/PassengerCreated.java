package org.t13.app.contracts.passenger;


import org.t13.app.core.event.IntegrationEvent;

import java.util.UUID;

public record PassengerCreated(UUID Id) implements IntegrationEvent {
}
