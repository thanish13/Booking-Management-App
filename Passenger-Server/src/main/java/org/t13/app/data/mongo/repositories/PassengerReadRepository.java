package org.t13.app.data.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.t13.app.data.mongo.documents.PassengerDocument;

import java.util.UUID;

public interface PassengerReadRepository extends MongoRepository<PassengerDocument, ObjectId> {
    PassengerDocument findPassengerByPassengerIdAndIsDeletedFalse(UUID passengerId);
}

