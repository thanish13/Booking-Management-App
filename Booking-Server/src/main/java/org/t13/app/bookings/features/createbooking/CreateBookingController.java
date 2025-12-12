package org.t13.app.bookings.features.createbooking;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.t13.app.bookings.dtos.BookingDto;
import org.t13.app.bookings.features.Mappings;
import org.t13.app.foundation.mediator.abstractions.IMediator;


@RestController
@RequestMapping(path = "api/v1/booking")
@Tag(name = "booking")
public class CreateBookingController {

    private final IMediator mediator;

    public CreateBookingController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    //@PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookingDto> createBooking(@RequestBody CreateBookingRequestDto createAirportRequestDto) {
        CreateBookingCommand command = Mappings.toCreateBookingCommand(createAirportRequestDto);
        var result = this.mediator.send(command);
        return ResponseEntity.ok().body(result);
    }
}

