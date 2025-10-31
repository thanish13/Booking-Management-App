package org.t13.app.listeners;

import org.t13.app.contracts.flight.FlightUpdated;
import org.t13.app.rabbitmq.MessageHandler;
import org.t13.app.utils.jsonconverter.JsonConverterUtils;
import org.slf4j.Logger;
import org.slf4j.event.KeyValuePair;
import org.springframework.stereotype.Component;

@Component
public class FlightUpdatedListener implements MessageHandler<FlightUpdated> {

  private final Logger logger;

  public FlightUpdatedListener(Logger logger) {
    this.logger = logger;
  }

  @Override
  public void onMessage(FlightUpdated flightUpdated) {
    logger.info("Do other processing after update flight in passenger service for this flight: {}", new KeyValuePair("flight_updated_event", JsonConverterUtils.serializeObject(flightUpdated)));
  }
}
