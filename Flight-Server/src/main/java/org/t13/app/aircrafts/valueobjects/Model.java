package org.t13.app.aircrafts.valueobjects;

import org.t13.app.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class Model {
  private String model;

  public Model(String value) {
    ValidationUtils.notBeNullOrEmpty(value);

    this.model = value;
  }
}


