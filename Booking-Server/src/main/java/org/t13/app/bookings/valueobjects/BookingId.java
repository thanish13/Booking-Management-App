package org.t13.app.bookings.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.t13.app.foundation.utils.validation.ValidationUtils;

import java.util.UUID;


@Embeddable
@EqualsAndHashCode
@NoArgsConstructor // Required by JPA
@Getter
public class BookingId {
    private UUID bookingId;

    public BookingId(UUID value) {
        ValidationUtils.notBeNullOrEmpty(value);

        this.bookingId = value;
    }
}

