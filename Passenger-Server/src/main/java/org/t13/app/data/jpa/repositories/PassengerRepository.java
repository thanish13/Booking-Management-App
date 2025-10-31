package org.t13.app.data.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.t13.app.data.jpa.entities.PassengerEntity;

import java.util.UUID;


@Repository
public interface PassengerRepository extends JpaRepository<PassengerEntity, UUID> {
    PassengerEntity findPassengerByPassportNumberAndIsDeletedFalse(String passportNumber);
}
