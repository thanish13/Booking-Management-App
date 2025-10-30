package org.t13.app.airports.features.createairport;

import org.t13.app.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.airports.dtos.AirportDto;
import org.t13.app.airports.exceptions.AirportAlreadyExistException;
import org.t13.app.airports.features.Mappings;
import org.t13.app.airports.models.Airport;
import org.t13.app.airports.valueobjects.Address;
import org.t13.app.airports.valueobjects.AirportId;
import org.t13.app.airports.valueobjects.Code;
import org.t13.app.airports.valueobjects.Name;
import org.t13.app.data.jpa.entities.AirportEntity;
import org.t13.app.data.jpa.repositories.AirportRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateAirportCommandHandler implements ICommandHandler<CreateAirportCommand, AirportDto> {
  private final AirportRepository airportRepository;

  public CreateAirportCommandHandler(
    AirportRepository airportRepository) {
    this.airportRepository = airportRepository;
  }

  @Override
  public AirportDto handle(CreateAirportCommand command) {

    AirportEntity existAirport = airportRepository.findAirportByCodeAndIsDeletedFalse(command.code());
    if (existAirport != null) {
      throw new AirportAlreadyExistException();
    }

    Airport airport = Airport.create(
      new AirportId(command.id()),
      new Name(command.name()),
      new Code(command.code()),
      new Address(command.address())
    );

    AirportEntity airportEntity = Mappings.toAirportEntity(airport);

    AirportEntity airportCreated = airportRepository.save(airportEntity);
    return Mappings.toAirportDto(airportCreated);
  }
}
