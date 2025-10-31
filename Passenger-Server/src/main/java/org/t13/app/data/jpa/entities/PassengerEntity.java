package org.t13.app.data.jpa.entities;

import org.t13.app.core.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.t13.app.passengers.enums.PassengerType;
import org.t13.app.passengers.valueobjects.Age;
import org.t13.app.passengers.valueobjects.Name;
import org.t13.app.passengers.valueobjects.PassportNumber;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "passengers")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PassengerEntity extends BaseEntity<UUID> {

    @Embedded
    private Name name;
    @Embedded
    private PassportNumber passportNumber;
    @Enumerated(EnumType.STRING)
    private PassengerType passengerType;
    @Embedded
    private Age age;

    public PassengerEntity(UUID id, Name name, PassportNumber passportNumber, PassengerType passengerType, Age age) {
        this.id = id;
        this.name = name;
        this.passportNumber = passportNumber;
        this.passengerType = passengerType;
        this.age = age;
    }

    public PassengerEntity(UUID id, Name name, PassportNumber passportNumber, PassengerType passengerType, Age age, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
        this.id = id;
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
}
