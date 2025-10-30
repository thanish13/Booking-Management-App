package org.t13.app.data.mongo.repositories;

import org.t13.app.data.mongo.documents.AircraftDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface AircraftReadRepository extends MongoRepository<AircraftDocument, ObjectId> {
  AircraftDocument findByAircraftIdAndIsDeletedFalse(UUID aircraftId);
}


