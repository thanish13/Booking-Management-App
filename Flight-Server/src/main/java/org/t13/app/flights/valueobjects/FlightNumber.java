package org.t13.app.flights.valueobjects;

import org.t13.app.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class FlightNumber {
  private String flightNumber;

  public FlightNumber(String value) {
    ValidationUtils.notBeNullOrEmpty(value);

    this.flightNumber = value;
  }
}
