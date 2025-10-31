package org.t13.app.data.mongo.documents;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.t13.app.passengers.enums.PassengerType;

import java.util.UUID;


@Document(collection = "passengers")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PassengerDocument {
    @Id
    private ObjectId id;
    private UUID passengerId;
    private String name;
    private String passportNumber;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    private int age;
    private boolean isDeleted;

    public PassengerDocument(UUID passengerId, String name, String passportNumber , PassengerType passengerType, int age, boolean isDeleted) {
        this.passengerId = passengerId;
        this.name = name;
        this.passportNumber = passportNumber;
        this.passengerType = passengerType;
        this.age = age;
        this.isDeleted = isDeleted;
    }
}

