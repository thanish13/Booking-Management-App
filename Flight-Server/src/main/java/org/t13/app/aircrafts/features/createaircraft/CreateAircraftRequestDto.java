package org.t13.app.aircrafts.features.createaircraft;

public record CreateAircraftRequestDto(
  String name,
  String model,
  int manufacturingYear){
}
