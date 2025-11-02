package org.t13.app.bookings.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.t13.app.foundation.utils.validation.ValidationUtils;

@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class PassengerInfo {
    private String name;

    public PassengerInfo(String name) {
        ValidationUtils.notBeNullOrEmpty(name);
        this.name = name;
    }
}
