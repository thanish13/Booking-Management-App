package org.t13.app.seats.valueobjects;

import org.t13.app.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class SeatNumber {
  private String seatNumber;

  public SeatNumber(String value) {
    ValidationUtils.notBeNullOrEmpty(value);

    this.seatNumber = value;
  }
}



