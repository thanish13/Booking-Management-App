package org.t13.app.data.jpa.repositories;

import org.t13.app.data.jpa.entities.AirportEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;


@Repository
public interface AirportRepository extends JpaRepository<AirportEntity, UUID> {
  AirportEntity findAirportByCodeAndIsDeletedFalse(String code);
}
