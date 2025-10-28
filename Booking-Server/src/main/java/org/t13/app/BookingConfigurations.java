package org.t13.app;

import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.t13.app.collector.OtelCollectorConfiguration;
import org.t13.app.core.event.EventDispatcherConfiguration;
import org.t13.app.jpa.JpaConfiguration;
import org.t13.app.keycloak.KeycloakConfiguration;
import org.t13.app.logger.LoggerConfiguration;
import org.t13.app.mediator.MediatorConfiguration;
import org.t13.app.mongo.MongoConfiguration;
import org.t13.app.outboxprocessor.PersistMessageProcessorConfiguration;
import org.t13.app.problemdetails.CustomProblemDetailsHandler;
import org.t13.app.rabbitmq.RabbitmqConfiguration;
import org.t13.app.swagger.SwaggerConfiguration;
import org.t13.app.threadpool.ThreadPoolConfiguration;
import org.t13.app.web.WebClientConfiguration;

@Configuration
@Import({
        CustomProblemDetailsHandler.class,
        JpaConfiguration.class,
        MongoConfiguration.class,
        LoggerConfiguration.class,
        FlywayAutoConfiguration.FlywayConfiguration.class,
        RabbitmqConfiguration.class,
        OtelCollectorConfiguration.class,
        SwaggerConfiguration.class,
        KeycloakConfiguration.class,
        WebClientConfiguration.class,
        ThreadPoolConfiguration.class,
        PersistMessageProcessorConfiguration.class,
        EventDispatcherConfiguration.class,
        MediatorConfiguration.class
})
public class BookingConfigurations {
}
