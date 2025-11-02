package org.t13.app.passengers.features.createpassenger;

import org.t13.app.data.jpa.entities.PassengerEntity;
import org.t13.app.data.jpa.repositories.PassengerRepository;
import org.t13.app.foundation.mediator.abstractions.commands.ICommandHandler;
import org.springframework.stereotype.Service;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.exceptions.PassengerAlreadyExistException;
import org.t13.app.passengers.features.Mappings;
import org.t13.app.passengers.models.Passenger;
import org.t13.app.passengers.valueobjects.Age;
import org.t13.app.passengers.valueobjects.Name;
import org.t13.app.passengers.valueobjects.PassengerId;
import org.t13.app.passengers.valueobjects.PassportNumber;

@Service
public class CreatePassengerCommandHandler implements ICommandHandler<CreatePassengerCommand, PassengerDto> {
    private final PassengerRepository passengerRepository;

    public CreatePassengerCommandHandler(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public PassengerDto handle(CreatePassengerCommand command) {

        PassengerEntity existPassenger = passengerRepository.findPassengerByPassportNumberAndIsDeletedFalse(command.passportNumber());
        if (existPassenger != null) {
         throw new PassengerAlreadyExistException();
        }

        Passenger passengerAggregate = Passenger.create(
                new PassengerId(command.id()),
                new Name(command.name()),
                new PassportNumber(command.passportNumber()),
                command.passengerType(),
                new Age(command.age())
        );

        PassengerEntity passengerEntity = Mappings.toPassengerEntity(passengerAggregate);

        PassengerEntity createdPassenger = passengerRepository.save(passengerEntity);

        return Mappings.toPassengerDto(createdPassenger);
    }
}
