package org.t13.app.aircrafts.features;

import com.github.f4b6a3.uuid.UuidCreator;
import org.t13.app.aircrafts.dtos.AircraftDto;
import org.t13.app.aircrafts.features.createaircraft.CreateAircraftCommand;
import org.t13.app.aircrafts.features.createaircraft.CreateAircraftMongoCommand;
import org.t13.app.aircrafts.features.createaircraft.CreateAircraftRequestDto;
import org.t13.app.aircrafts.models.Aircraft;
import org.t13.app.data.jpa.entities.AircraftEntity;
import org.t13.app.data.mongo.documents.AircraftDocument;

public final class Mappings {

  public static AircraftEntity toAircraftEntity(Aircraft aircraft) {
    return new AircraftEntity(
      aircraft.getId().getAircraftId(),
      aircraft.getName(),
      aircraft.getModel(),
      aircraft.getManufacturingYear(),
      aircraft.getCreatedAt(),
      aircraft.getCreatedBy(),
      aircraft.getLastModified(),
      aircraft.getLastModifiedBy(),
      aircraft.getVersion(),
      aircraft.isDeleted()
    );
  }


  public static AircraftDto toAircraftDto(AircraftEntity aircraftEntity) {
    return new AircraftDto(
      aircraftEntity.getId(),
      aircraftEntity.getName().getName(),
      aircraftEntity.getModel().getModel(),
      aircraftEntity.getManufacturingYear().getManufacturingYear());
  }

  public static CreateAircraftCommand toCreateAircraftCommand(CreateAircraftRequestDto createAircraftRequestDto) {
    return new CreateAircraftCommand(
      UuidCreator.getTimeOrderedEpoch(),
      createAircraftRequestDto.name(),
      createAircraftRequestDto.model(),
      createAircraftRequestDto.manufacturingYear()
    );
  }

  public static AircraftDocument toAircraftDocument(CreateAircraftMongoCommand createAircraftMongoCommand) {
    return new AircraftDocument(
      createAircraftMongoCommand.id(),
      createAircraftMongoCommand.name(),
      createAircraftMongoCommand.model(),
      createAircraftMongoCommand.manufacturingYear(),
      createAircraftMongoCommand.isDeleted()
    );
  }

  public static AircraftDocument toAircraftDocument(AircraftEntity aircraftEntity) {
    return new AircraftDocument(
      aircraftEntity.getId(),
      aircraftEntity.getName().getName(),
      aircraftEntity.getModel().getModel(),
      aircraftEntity.getManufacturingYear().getManufacturingYear(),
      aircraftEntity.isDeleted()
    );
  }
}
