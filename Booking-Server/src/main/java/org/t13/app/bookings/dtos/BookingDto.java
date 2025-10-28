package org.t13.app.bookings.dtos;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record BookingDto(
        UUID id,
        String name,
        String flightNumber,
        UUID aircraftId,
        BigDecimal price,
        LocalDateTime flightDate,
        String seatNumber,
        UUID departureAirportId,
        UUID arriveAirportId,
        String description
) { }