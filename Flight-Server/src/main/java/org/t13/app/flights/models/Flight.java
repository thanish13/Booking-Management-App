package org.t13.app.flights.models;

import org.t13.app.core.model.AggregateRoot;
import org.t13.app.aircrafts.valueobjects.AircraftId;
import org.t13.app.airports.valueobjects.AirportId;
import org.t13.app.flights.enums.FlightStatus;
import org.t13.app.flights.features.createflight.FlightCreatedDomainEvent;
import org.t13.app.flights.features.deleteflight.FlightDeletedDomainEvent;
import org.t13.app.flights.features.updateflight.FlightUpdatedDomainEvent;
import lombok.*;
import org.t13.app.flights.valueobjects.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter(AccessLevel.PRIVATE)
public class Flight extends AggregateRoot<FlightId> {
  FlightNumber flightNumber;
  AircraftId aircraftId;
  AirportId departureAirportId;
  AirportId arriveAirportId;
  DurationMinutes durationMinutes;
  FlightStatus status;
  Price price;
  ArriveDate arriveDate;
  DepartureDate departureDate;
  FlightDate flightDate;


  public Flight(FlightId flightId, FlightNumber flightNumber, AircraftId aircraftId, AirportId departureAirportId, AirportId arriveAirportId, DurationMinutes durationMinutes, FlightStatus status, Price price, ArriveDate arriveDate, DepartureDate departureDate, FlightDate flightDate, LocalDateTime createdAt, Long createdBy, LocalDateTime lastModified, Long lastModifiedBy, Long version, boolean isDeleted) {
    this.id = flightId;
    this.flightNumber = flightNumber;
    this.aircraftId = aircraftId;
    this.departureAirportId = departureAirportId;
    this.arriveAirportId = arriveAirportId;
    this.durationMinutes = durationMinutes;
    this.status = status;
    this.price = price;
    this.arriveDate = arriveDate;
    this.departureDate = departureDate;
    this.flightDate = flightDate;
    this.createdAt = createdAt;
    this.createdBy = createdBy;
    this.lastModified = lastModified;
    this.lastModifiedBy = lastModifiedBy;
    this.version = version;
    this.isDeleted = isDeleted;
  }

  public Flight(FlightId flightId, FlightNumber flightNumber, AircraftId aircraftId, AirportId departureAirportId, AirportId arriveAirportId, DurationMinutes durationMinutes, FlightStatus status, Price price, ArriveDate arriveDate, DepartureDate departureDate, FlightDate flightDate) {
    this.id = flightId;
    this.flightNumber = flightNumber;
    this.aircraftId = aircraftId;
    this.departureAirportId = departureAirportId;
    this.arriveAirportId = arriveAirportId;
    this.durationMinutes = durationMinutes;
    this.status = status;
    this.price = price;
    this.arriveDate = arriveDate;
    this.departureDate = departureDate;
    this.flightDate = flightDate;
  }

  public static Flight create(FlightId id, FlightNumber flightNumber, AircraftId aircraftId, AirportId departureAirportId, DepartureDate departureDate, ArriveDate arriveDate, AirportId arriveAirportId, DurationMinutes durationMinutes, FlightDate flightDate, FlightStatus status, Price price) {
    var flight = new Flight(id, flightNumber, aircraftId, departureAirportId, arriveAirportId, durationMinutes, status, price, arriveDate, departureDate, flightDate);

    flight.addDomainEvent(new FlightCreatedDomainEvent(
      flight.getId().getFlightId(),
      flight.flightNumber.getFlightNumber(),
      flight.aircraftId.getAircraftId(),
      flight.departureAirportId.getAirportId(),
      flight.departureDate.getDepartureDate(),
      flight.arriveDate.getArriveDate(),
      flight.arriveAirportId.getAirportId(),
      flight.durationMinutes.getDurationMinutes(),
      flight.flightDate.getFlightDate(),
      flight.status,
      flight.price.getPrice(),
      false
    ));

    return flight;
  }

  public void update(FlightId id, FlightNumber flightNumber, AircraftId aircraftId, AirportId departureAirportId, DepartureDate departureDate, ArriveDate arriveDate, AirportId arriveAirportId, DurationMinutes durationMinutes, FlightDate flightDate, FlightStatus status, Price price, boolean isDeleted) {

    this.id = id;
    this.flightNumber = flightNumber;
    this.aircraftId = aircraftId;
    this.departureAirportId = departureAirportId;
    this.arriveAirportId = arriveAirportId;
    this.durationMinutes = durationMinutes;
    this.status = status;
    this.price = price;
    this.arriveDate = arriveDate;
    this.departureDate = departureDate;
    this.flightDate = flightDate;
    this.isDeleted = isDeleted;

    this.addDomainEvent(new FlightUpdatedDomainEvent(id.getFlightId(), flightNumber.getFlightNumber(), aircraftId.getAircraftId(), departureAirportId.getAirportId(), departureDate.getDepartureDate(),
      arriveDate.getArriveDate(), arriveAirportId.getAirportId(), durationMinutes.getDurationMinutes(), flightDate.getFlightDate(), status, price.getPrice(), isDeleted));
  }

  public void delete() {

    this.isDeleted = true;

    this.addDomainEvent(new FlightDeletedDomainEvent(this.id.getFlightId(), this.flightNumber.getFlightNumber(), this.aircraftId.getAircraftId(), this.departureAirportId.getAirportId(), this.departureDate.getDepartureDate(),
      this.arriveDate.getArriveDate(), this.arriveAirportId.getAirportId(), this.durationMinutes.getDurationMinutes(), this.flightDate.getFlightDate(), this.status, this.price.getPrice(), true));
  }
}
