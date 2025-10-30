package org.t13.app.data.mongo.repositories;

import org.t13.app.data.mongo.documents.SeatDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface SeatReadRepository extends MongoRepository<SeatDocument, ObjectId> {
  SeatDocument findSeatByFlightIdAndSeatNumberAndIsDeletedFalse(UUID flightId, String seatNumber);
  List<SeatDocument> findAllSeatsByFlightIdAndIsDeletedFalse(UUID flightId);
}

