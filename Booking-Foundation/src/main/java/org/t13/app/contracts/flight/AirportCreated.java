package org.t13.app.contracts.flight;

import buildingblocks.core.event.IntegrationEvent;

import java.util.UUID;

public record AirportCreated(UUID Id) implements IntegrationEvent {
}




