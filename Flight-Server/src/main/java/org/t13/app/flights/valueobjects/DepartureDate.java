package org.t13.app.flights.valueobjects;

import org.t13.app.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class DepartureDate {
  private LocalDateTime departureDate;

  public DepartureDate(LocalDateTime value) {
    ValidationUtils.validLocalDateTime(value);

    this.departureDate = value;
  }
}

