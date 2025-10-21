package org.t13.app.contracts.passenger;

import buildingblocks.core.event.IntegrationEvent;

import java.util.UUID;

public record PassengerCreated(UUID Id) implements IntegrationEvent {
}
