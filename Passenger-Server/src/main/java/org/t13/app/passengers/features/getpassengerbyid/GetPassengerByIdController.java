package org.t13.app.passengers.features.getpassengerbyid;

import org.t13.app.mediator.abstractions.IMediator;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.t13.app.passengers.dtos.PassengerDto;

import java.util.UUID;


@RestController
@RequestMapping(path = "api/v1/passenger")
@Tag(name = "passenger")
public class GetPassengerByIdController {

    private final IMediator mediator;

    public GetPassengerByIdController(IMediator mediator) {
        this.mediator = mediator;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PassengerDto> getPassengerById(@PathVariable UUID id) {
        PassengerDto result = this.mediator.send(new GetPassengerByIdQuery(id));
        return ResponseEntity.ok().body(result);
    }
}

