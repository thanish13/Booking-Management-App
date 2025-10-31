package org.t13.app.passengers.features.createpassenger;

import org.t13.app.data.mongo.documents.PassengerDocument;
import org.t13.app.data.mongo.repositories.PassengerReadRepository;
import org.t13.app.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.mediator.abstractions.requests.Unit;
import org.springframework.stereotype.Service;
import org.t13.app.passengers.exceptions.PassengerAlreadyExistException;
import org.t13.app.passengers.features.Mappings;

@Service
public class CreatePassengerMongoCommandHandler implements ICommandHandler<CreatePassengerMongoCommand, Unit> {

    private final PassengerReadRepository passengerReadRepository;

    public CreatePassengerMongoCommandHandler(PassengerReadRepository passengerReadRepository) {
        this.passengerReadRepository = passengerReadRepository;
    }

    public Unit handle(CreatePassengerMongoCommand command) {

        PassengerDocument passengerDocument = Mappings.toPassengerDocument(command);

        var passengerExist = passengerReadRepository.findPassengerByPassengerIdAndIsDeletedFalse(passengerDocument.getPassengerId());

        if (passengerExist != null) {
            throw new PassengerAlreadyExistException();
        }

        passengerReadRepository.save(passengerDocument);

        return Unit.VALUE;
    }
}

