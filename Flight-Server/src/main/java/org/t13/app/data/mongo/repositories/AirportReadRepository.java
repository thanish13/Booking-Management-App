package org.t13.app.data.mongo.repositories;

import org.t13.app.data.mongo.documents.AirportDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.UUID;

public interface AirportReadRepository extends MongoRepository<AirportDocument, ObjectId> {
  AirportDocument findByAirportIdAndIsDeletedFalse(UUID airportId);
}

