package org.t13.app.airports.features;

import com.github.f4b6a3.uuid.UuidCreator;
import org.t13.app.airports.dtos.AirportDto;
import org.t13.app.airports.features.createairport.CreateAirportCommand;
import org.t13.app.airports.features.createairport.CreateAirportMongoCommand;
import org.t13.app.airports.features.createairport.CreateAirportRequestDto;
import org.t13.app.airports.models.Airport;
import org.t13.app.data.jpa.entities.AirportEntity;
import org.t13.app.data.mongo.documents.AirportDocument;

public final class Mappings {

  public static AirportEntity toAirportEntity(Airport airport) {
    return new AirportEntity(
      airport.getId().getAirportId(),
      airport.getName(),
      airport.getCode(),
      airport.getAddress(),
      airport.getCreatedAt(),
      airport.getCreatedBy(),
      airport.getLastModified(),
      airport.getLastModifiedBy(),
      airport.getVersion(),
      airport.isDeleted()
    );
  }


  public static AirportDto toAirportDto(AirportEntity airportEntity) {
    return new AirportDto(
      airportEntity.getId(),
      airportEntity.getName().getName(),
      airportEntity.getCode().getCode(),
      airportEntity.getAddress().getAddress());
  }

  public static CreateAirportCommand toCreateAirportCommand(CreateAirportRequestDto createAirportRequestDto) {
    return new CreateAirportCommand(
      UuidCreator.getTimeOrderedEpoch(),
      createAirportRequestDto.name(),
      createAirportRequestDto.code(),
      createAirportRequestDto.address()
    );
  }

  public static AirportDocument toAirportDocument(CreateAirportMongoCommand createAirportMongoCommand) {
    return new AirportDocument(
      createAirportMongoCommand.id(),
      createAirportMongoCommand.name(),
      createAirportMongoCommand.code(),
      createAirportMongoCommand.address(),
      createAirportMongoCommand.isDeleted()
    );
  }

  public static AirportDocument toAirportDocument(AirportEntity airportEntity) {
    return new AirportDocument(
      airportEntity.getId(),
      airportEntity.getName().getName(),
      airportEntity.getCode().getCode(),
      airportEntity.getAddress().getAddress(),
      airportEntity.isDeleted()
    );
  }
}
