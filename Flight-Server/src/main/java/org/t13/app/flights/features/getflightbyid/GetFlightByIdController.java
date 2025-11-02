package org.t13.app.flights.features.getflightbyid;

import org.t13.app.foundation.mediator.abstractions.IMediator;
import org.t13.app.flights.dtos.FlightDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/flight")
@Tag(name = "flight")
public class GetFlightByIdController {

  private final IMediator mediator;

  public GetFlightByIdController(IMediator mediator) {
    this.mediator = mediator;
  }

  @GetMapping("/{id}")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<FlightDto> getFlightById(@PathVariable UUID id) {
    FlightDto result = this.mediator.send(new GetFlightByIdQuery(id));
    return ResponseEntity.ok().body(result);
  }
}
