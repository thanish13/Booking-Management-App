package org.t13.app.airports.features.createairport;

public record CreateAirportRequestDto(
  String name,
  String code,
  String address){
}

