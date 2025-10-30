package org.t13.app.flights.features.updateflight;

import buildingblocks.mediator.abstractions.IMediator;
import org.t13.app.flights.dtos.FlightDto;
import org.t13.app.flights.features.Mappings;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping(path = "api/v1/flight")
@Tag(name = "flight")
public class UpdateFlightController {

  private final IMediator mediator;

  public UpdateFlightController(IMediator mediator) {
    this.mediator = mediator;
  }

  @PutMapping("/{id}")
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<FlightDto> updateFlight(@PathVariable UUID id, @RequestBody UpdateFlightRequestDto updateFlightRequestDto) {
    UpdateFlightCommand command = Mappings.toUpdateFlightCommand(id, updateFlightRequestDto);
    this.mediator.send(command);
    return ResponseEntity.noContent().build();
  }
}


