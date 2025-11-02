package org.t13.app.flights.valueobjects;

import org.t13.app.foundation.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class DurationMinutes {
  private BigDecimal durationMinutes;

  public DurationMinutes(BigDecimal value) {
    ValidationUtils.notBeNegativeOrNull(value);

    this.durationMinutes = value;
  }
}

