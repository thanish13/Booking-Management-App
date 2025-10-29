package org.t13.app.data.jpa.entities;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.t13.app.bookings.valueobjects.PassengerInfo;
import org.t13.app.bookings.valueobjects.Trip;
import org.t13.app.core.model.BaseEntity;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Table(name = "bookings")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class BookingEntity extends BaseEntity<UUID> {

    @Embedded
    private PassengerInfo passengerInfo;
    @Embedded
    private Trip trip;

    public BookingEntity(UUID id, PassengerInfo passengerInfo, Trip trip, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
        this.id = id;
        this.passengerInfo = passengerInfo;
        this.trip = trip;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastModified = lastModified;
        this.lastModifiedBy = lastModifiedBy;
        this.version = version;
        this.isDeleted = isDeleted;
    }

    public BookingEntity(UUID id, PassengerInfo passengerInfo, Trip trip) {
        this.id = id;
        this.passengerInfo = passengerInfo;
        this.trip = trip;
    }
}
