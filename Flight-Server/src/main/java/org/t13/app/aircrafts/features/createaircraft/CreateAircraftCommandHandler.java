package org.t13.app.aircrafts.features.createaircraft;

import org.t13.app.aircrafts.dtos.AircraftDto;
import org.t13.app.aircrafts.exceptions.AircraftAlreadyExistException;
import org.t13.app.aircrafts.features.Mappings;
import org.t13.app.aircrafts.models.Aircraft;
import org.t13.app.aircrafts.valueobjects.AircraftId;
import org.t13.app.aircrafts.valueobjects.ManufacturingYear;
import org.t13.app.aircrafts.valueobjects.Model;
import org.t13.app.aircrafts.valueobjects.Name;
import org.t13.app.data.jpa.entities.AircraftEntity;
import org.t13.app.data.jpa.repositories.AircraftRepository;
import org.springframework.stereotype.Service;
import org.t13.app.foundation.mediator.abstractions.commands.ICommandHandler;

@Service
public class CreateAircraftCommandHandler implements ICommandHandler<CreateAircraftCommand, AircraftDto> {

  private final AircraftRepository aircraftRepository;

  public CreateAircraftCommandHandler(AircraftRepository aircraftRepository) {
    this.aircraftRepository = aircraftRepository;
  }

  @Override
  public AircraftDto handle(CreateAircraftCommand command) {

    AircraftEntity existAircraft = aircraftRepository.findAircraftByModelAndIsDeletedFalse(command.model());
    if (existAircraft != null) {
      throw new AircraftAlreadyExistException();
    }

    Aircraft aircraft = Aircraft.create(
      new AircraftId(command.id()),
      new Name(command.name()),
      new Model(command.model()),
      new ManufacturingYear(command.manufacturingYear())
    );

    AircraftEntity aircraftEntity = Mappings.toAircraftEntity(aircraft);

    AircraftEntity aircraftCreated = aircraftRepository.save(aircraftEntity);
    return Mappings.toAircraftDto(aircraftCreated);
  }
}
