package org.t13.app.passengers.models;

import org.t13.app.core.model.AggregateRoot;
import lombok.*;
import org.t13.app.passengers.enums.PassengerType;
import org.t13.app.passengers.features.createpassenger.PassengerCreatedDomainEvent;
import org.t13.app.passengers.valueobjects.Age;
import org.t13.app.passengers.valueobjects.Name;
import org.t13.app.passengers.valueobjects.PassengerId;
import org.t13.app.passengers.valueobjects.PassportNumber;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PRIVATE)
public class Passenger extends AggregateRoot<PassengerId> {
    Name name;
    PassportNumber passportNumber;
    PassengerType passengerType;
    Age age;

    public Passenger(PassengerId passengerId, Name name, PassportNumber passportNumber, PassengerType passengerType, Age age, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
       this.id = passengerId;
       this.name = name;
       this.passportNumber = passportNumber;
       this.passengerType = passengerType;
       this.age = age;
       this.createdAt = createdAt;
       this.createdBy = createdBy;
       this.lastModified = lastModified;
       this.lastModifiedBy = lastModifiedBy;
       this.version = version;
       this.isDeleted = isDeleted;
    }

    public Passenger(PassengerId passengerId, Name name, PassportNumber passportNumber, PassengerType passengerType, Age age) {
        this.id = passengerId;
        this.name = name;
        this.passportNumber = passportNumber;
        this.passengerType = passengerType;
        this.age = age;
    }

    public static Passenger create(PassengerId passengerId, Name name, PassportNumber passportNumber, PassengerType passengerType, Age age) {
        var passenger = new Passenger(passengerId, name, passportNumber, passengerType, age);

        passenger.addDomainEvent(new PassengerCreatedDomainEvent(
                passenger.id.getPassengerId(),
                passenger.name.getName(),
                passenger.passportNumber.getPassportNumber(),
                passenger.passengerType,
                passenger.age.getAge(),
                false
        ));

        return passenger;
    }
}
