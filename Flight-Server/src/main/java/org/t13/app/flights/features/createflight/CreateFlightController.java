package org.t13.app.flights.features.createflight;

import org.t13.app.mediator.abstractions.IMediator;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.features.Mappings;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/flight")
@Tag(name = "flight")
public class CreateFlightController {

  private final IMediator mediator;

  public CreateFlightController(IMediator mediator) {
    this.mediator = mediator;
  }

  @PostMapping()
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<FlightDto> createFlight(@RequestBody CreateFlightRequestDto createFlightRequestDto) {
    CreateFlightCommand command = Mappings.toCreateFlightCommand(createFlightRequestDto);
    var result = this.mediator.send(command);
    return ResponseEntity.ok().body(result);
  }
}
