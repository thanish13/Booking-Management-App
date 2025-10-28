package org.t13.app.bookings.valueobjects;

import buildingblocks.utils.validation.ValidationUtils;
import jakarta.persistence.Embeddable;

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
