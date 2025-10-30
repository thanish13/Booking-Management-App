package org.t13.app.seats.features.reserveseat;

import org.t13.app.mediator.abstractions.IMediator;
import org.t13.app.seats.dtos.SeatDto;
import org.t13.app.seats.features.Mappings;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "api/v1/flight/reserve-seat")
@Tag(name = "flight")
public class ReserveSeatController {

  private final IMediator mediator;

  public ReserveSeatController(IMediator mediator) {
    this.mediator = mediator;
  }

  @PostMapping()
  @PreAuthorize("hasAuthority('ADMIN')")
  public ResponseEntity<SeatDto> createAircraft(@RequestBody ReserveSeatRequestDto reserveSeatRequestDto) {
    ReserveSeatCommand command = Mappings.toReserveSeatCommand(reserveSeatRequestDto);
    var result = this.mediator.send(command);
    return ResponseEntity.ok().body(result);
  }
}


