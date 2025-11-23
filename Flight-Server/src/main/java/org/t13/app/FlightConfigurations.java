package org.t13.app;

import org.t13.app.foundation.collector.OtelCollectorConfiguration;
import org.t13.app.foundation.core.event.EventDispatcherConfiguration;
import org.t13.app.foundation.jpa.JpaConfiguration;
import org.t13.app.foundation.keycloak.KeycloakConfiguration;
import org.t13.app.foundation.logger.LoggerConfiguration;
import org.t13.app.foundation.mediator.MediatorConfiguration;
import org.t13.app.foundation.mongo.MongoConfiguration;
import org.t13.app.foundation.outboxprocessor.PersistMessageProcessorConfiguration;
import org.t13.app.foundation.problemdetails.CustomProblemDetailsHandler;
import org.t13.app.foundation.rabbitmq.RabbitmqConfiguration;
import org.t13.app.foundation.swagger.SwaggerConfiguration;
import org.t13.app.foundation.threadpool.ThreadPoolConfiguration;
import org.t13.app.foundation.web.WebClientConfiguration;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

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
//  KeycloakConfiguration.class,
  WebClientConfiguration.class,
  ThreadPoolConfiguration.class,
  PersistMessageProcessorConfiguration.class,
  EventDispatcherConfiguration.class,
  MediatorConfiguration.class
})
public class FlightConfigurations {
}


