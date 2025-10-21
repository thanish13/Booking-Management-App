package org.t13.app.buildingblocks.core.event;

public interface EventMapper {
    IntegrationEvent MapToIntegrationEvent(DomainEvent event);
    InternalCommand MapToInternalCommand(DomainEvent event);
}