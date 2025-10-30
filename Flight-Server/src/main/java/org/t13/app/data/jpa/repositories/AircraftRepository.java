package org.t13.app.data.jpa.repositories;

import org.t13.app.data.jpa.entities.AircraftEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AircraftRepository extends JpaRepository<AircraftEntity, UUID> {
  AircraftEntity findAircraftByModelAndIsDeletedFalse(String model);
}
