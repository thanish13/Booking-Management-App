package org.t13.app.passengers.features;

import com.github.f4b6a3.uuid.UuidCreator;
import org.t13.app.data.jpa.entities.PassengerEntity;
import org.t13.app.data.mongo.documents.PassengerDocument;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.enums.PassengerType;
import org.t13.app.passengers.features.createpassenger.CreatePassengerCommand;
import org.t13.app.passengers.features.createpassenger.CreatePassengerMongoCommand;
import org.t13.app.passengers.features.createpassenger.CreatePassengerRequestDto;
import org.t13.app.passengers.models.Passenger;

public final class Mappings {

    public static PassengerEntity toPassengerEntity(Passenger passenger) {
        return new PassengerEntity(
                passenger.getId().getPassengerId(),
                passenger.getName(),
                passenger.getPassportNumber(),
                passenger.getPassengerType(),
                passenger.getAge(),
                passenger.getCreatedAt(),
                passenger.getCreatedBy(),
                passenger.getLastModified(),
                passenger.getLastModifiedBy(),
                passenger.getVersion(),
                passenger.isDeleted()
        );
    }

    public static PassengerDto toPassengerDto(PassengerEntity passengerEntity) {
        return new PassengerDto(
                passengerEntity.getId(),
                passengerEntity.getName().getName(),
                passengerEntity.getPassportNumber().getPassportNumber(),
                passengerEntity.getPassengerType(),
                passengerEntity.getAge().getAge());
    }


    public static PassengerDocument toPassengerDocument(CreatePassengerMongoCommand createPassengerMongoCommand) {
        return new PassengerDocument(
                createPassengerMongoCommand.id(),
                createPassengerMongoCommand.name(),
                createPassengerMongoCommand.passportNumber(),
                createPassengerMongoCommand.passengerType(),
                createPassengerMongoCommand.age(),
                createPassengerMongoCommand.isDeleted()
        );
    }

    public static PassengerDocument toPassengerDocument(PassengerEntity passengerEntity) {
        return new PassengerDocument(
                passengerEntity.getId(),
                passengerEntity.getName().getName(),
                passengerEntity.getPassportNumber().getPassportNumber(),
                passengerEntity.getPassengerType(),
                passengerEntity.getAge().getAge(),
                passengerEntity.isDeleted()
        );
    }

    public static CreatePassengerCommand toCreatePassengerCommand(CreatePassengerRequestDto passengerRequestDto) {
        return new CreatePassengerCommand(
                UuidCreator.getTimeOrderedEpoch(),
                passengerRequestDto.name(),
                passengerRequestDto.PassportNumber(),
                passengerRequestDto.passengerType(),
                passengerRequestDto.age()
        );
    }


    public static PassengerDto toPassengerDto(PassengerDocument passengerDocument) {
        return new PassengerDto(
                passengerDocument.getPassengerId(),
                passengerDocument.getName(),
                passengerDocument.getPassportNumber(),
                passengerDocument.getPassengerType(),
                passengerDocument.getAge()
        );
    }

    public static passenger.Passenger.PassengerResponseDto toPassengerResponseDtoGrpc(PassengerDto passengerDto) {

        return passenger.Passenger.PassengerResponseDto.newBuilder()
                .setId(passengerDto.id().toString())
                .setName(passengerDto.name())
                .setPassportNumber(passengerDto.passportNumber())
                .setPassengerType(toPassengerTypeGrpc(passengerDto.passengerType()))
                .setAge(passengerDto.age())
                .build();
    }

    public static passenger.Passenger.PassengerType toPassengerTypeGrpc(PassengerType passengerType) {
        return switch (passengerType) {
            case Male -> passenger.Passenger.PassengerType.PASSENGER_TYPE_MALE;
            case Female -> passenger.Passenger.PassengerType.PASSENGER_TYPE_FEMALE;
            case Baby -> passenger.Passenger.PassengerType.PASSENGER_TYPE_BABY;
        };
    }
}