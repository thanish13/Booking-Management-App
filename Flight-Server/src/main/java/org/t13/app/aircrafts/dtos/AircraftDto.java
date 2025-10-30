package org.t13.app.aircrafts.dtos;

import java.util.UUID;

public record AircraftDto(
  UUID id,
  String name,
  String model,
  int manufacturingYear
) { }


