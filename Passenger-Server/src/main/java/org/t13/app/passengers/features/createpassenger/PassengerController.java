package org.t13.app.passengers.features.createpassenger;

import org.t13.app.mediator.abstractions.IMediator;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.features.Mappings;


@RestController
@RequestMapping(path = "api/v1/passenger")
@Tag(name = "passenger")
public class PassengerController {

    private final IMediator mediator;

    public PassengerController(IMediator mediator) {
        this.mediator = mediator;
    }

    @PostMapping()
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PassengerDto> createPassenger(@RequestBody CreatePassengerRequestDto createPassengerRequestDto) {
        CreatePassengerCommand command = Mappings.toCreatePassengerCommand(createPassengerRequestDto);
        var result = this.mediator.send(command);
        return ResponseEntity.ok().body(result);
    }
}

