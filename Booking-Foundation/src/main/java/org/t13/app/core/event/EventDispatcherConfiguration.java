package org.t13.app.core.event;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.t13.app.outboxprocessor.PersistMessageProcessor;

@Configuration
public class EventDispatcherConfiguration {

    @Bean
    @ConditionalOnMissingClass
    public EventDispatcher eventDispatcher(EventMapper eventMapper, PersistMessageProcessor persistMessageProcessor, ApplicationContext applicationContext) {
        return new EventDispatcherImpl(eventMapper, persistMessageProcessor, applicationContext);
    }
}
