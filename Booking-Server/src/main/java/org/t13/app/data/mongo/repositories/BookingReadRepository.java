package org.t13.app.data.mongo.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.t13.app.data.mongo.documents.BookingDocument;
import java.util.UUID;


public interface BookingReadRepository extends MongoRepository<BookingDocument, ObjectId> {
    BookingDocument findBookingByBookingIdAndIsDeletedFalse(UUID bookingId);
}

