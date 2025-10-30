package org.t13.app.data.mongo.repositories;

import org.t13.app.data.mongo.documents.FlightDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface FlightReadRepository extends MongoRepository<FlightDocument, ObjectId> {
  FlightDocument findByFlightIdAndIsDeletedFalse(UUID flightId);
  List<FlightDocument> findAllByIsDeletedFalse();
}
