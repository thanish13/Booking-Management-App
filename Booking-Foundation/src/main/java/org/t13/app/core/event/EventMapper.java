package org.t13.app.core.event;

public interface EventMapper {
    IntegrationEvent MapToIntegrationEvent(DomainEvent event);
    InternalCommand MapToInternalCommand(DomainEvent event);
}