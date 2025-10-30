package org.t13.app.aircrafts.features.createaircraft;

import org.t13.app.core.event.DomainEvent;

import java.util.UUID;

public record AircraftCreatedDomainEvent(
  UUID id,
  String name,
  String model,
  int manufacturingYear,
  boolean isDeleted) implements DomainEvent {
}
