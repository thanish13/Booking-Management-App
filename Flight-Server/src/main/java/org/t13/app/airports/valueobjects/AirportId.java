package org.t13.app.airports.valueobjects;

import org.t13.app.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class AirportId {
  private UUID airportId;

  public AirportId(UUID value) {
    ValidationUtils.notBeNullOrEmpty(value);

    this.airportId = value;
  }
}



