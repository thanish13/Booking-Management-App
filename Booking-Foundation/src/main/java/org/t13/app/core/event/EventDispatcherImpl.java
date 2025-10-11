package org.t13.app.core.event;

import org.t13.app.core.model.AggregateRoot;
import buildingblocks.outboxprocessor.PersistMessageProcessor;
import buildingblocks.outboxprocessor.PersistMessageProcessorConfiguration;
import buildingblocks.utils.reflection.ReflectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Import(PersistMessageProcessorConfiguration.class)
public class EventDispatcherImpl implements EventDispatcher {

    private final EventMapper eventMapper;
    private final PersistMessageProcessor persistMessageProcessor;
    private final ApplicationContext applicationContext;

    public EventDispatcherImpl(EventMapper eventMapper, PersistMessageProcessor persistMessageProcessor, ApplicationContext applicationContext) {
        this.eventMapper = eventMapper;
        this.persistMessageProcessor = persistMessageProcessor;
        this.applicationContext = applicationContext;
    }

    @Override
    public <T extends DomainEvent> void send(List<T> domainEvents, Class<?> eventType) {
        List<IntegrationEvent> integrationEvents = domainEvents.stream().map(eventMapper::MapToIntegrationEvent).toList();

        integrationEvents.forEach(persistMessageProcessor::publishMessage);

        if (InternalCommand.class.isAssignableFrom(eventType)) {
            List<InternalCommand> internalCommands = domainEvents.stream().map(eventMapper::MapToInternalCommand).toList();
            internalCommands.forEach(persistMessageProcessor::addInternalMessage);
        }
    }

    @Override
    public List<DomainEvent> getDomainEvents() {
            AggregateRoot<?> aggregateRoot = ReflectionUtils.getInstanceOfSubclass(AggregateRoot.class, applicationContext);
            return Objects.requireNonNull(aggregateRoot).getDomainEvents();
    }

    @Override
    public void clearDomainEvents() {
        AggregateRoot<?> aggregateRoot = ReflectionUtils.getInstanceOfSubclass(AggregateRoot.class, applicationContext);
         Objects.requireNonNull(aggregateRoot).clearDomainEvents();
    }
}
