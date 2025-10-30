package org.t13.app.data.jpa.repositories;

import org.t13.app.data.jpa.entities.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<FlightEntity, UUID> {
  FlightEntity findFlightByIdAndIsDeletedFalse(UUID id);
}
