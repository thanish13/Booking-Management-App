package org.t13.app.data.jpa.entities;

import org.t13.app.core.model.BaseEntity;
import org.t13.app.seats.enums.SeatClass;
import org.t13.app.seats.enums.SeatType;
import org.t13.app.seats.valueobjects.FlightId;
import org.t13.app.seats.valueobjects.SeatNumber;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "seats")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class SeatEntity extends BaseEntity<UUID> {
  @Embedded
  private SeatNumber seatNumber;
  @Enumerated(EnumType.STRING)
  private SeatType type;
  @Enumerated(EnumType.STRING)
  private SeatClass seatClass;

  @Embedded
  @AttributeOverride(name = "flightId", column = @Column(name = "flight_id"))
  private FlightId flightId;

  public SeatEntity(UUID id, SeatNumber seatNumber, SeatType type, SeatClass seatClass, FlightId flightId,
                    LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
    this.id = id;
    this.seatNumber = seatNumber;
    this.type = type;
    this.seatClass = seatClass;
    this.flightId = flightId;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.lastModified = lastModified;
    this.lastModifiedBy = lastModifiedBy;
    this.version = version;
    this.isDeleted = isDeleted;
  }

  public SeatEntity(UUID id, SeatNumber seatNumber, SeatType type, SeatClass seatClass, FlightId flightId) {
    this.id = id;
    this.seatNumber = seatNumber;
    this.type = type;
    this.seatClass = seatClass;
    this.flightId = flightId;
  }
}

