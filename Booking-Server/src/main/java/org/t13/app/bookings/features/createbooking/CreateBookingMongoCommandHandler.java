package org.t13.app.bookings.features.createbooking;

import org.springframework.stereotype.Service;
import org.t13.app.bookings.exceptions.BookingAlreadyExistException;
import org.t13.app.bookings.features.Mappings;
import org.t13.app.data.mongo.documents.BookingDocument;
import org.t13.app.data.mongo.repositories.BookingReadRepository;
import org.t13.app.foundation.mediator.abstractions.commands.ICommandHandler;
import org.t13.app.foundation.mediator.abstractions.requests.Unit;

@Service
public class CreateBookingMongoCommandHandler implements ICommandHandler<CreateBookingMongoCommand, Unit> {
    private final BookingReadRepository bookingReadRepository;

    public CreateBookingMongoCommandHandler(BookingReadRepository bookingReadRepository) {
        this.bookingReadRepository = bookingReadRepository;
    }

    @Override
    public Unit handle(CreateBookingMongoCommand command) {

        BookingDocument existBooking = bookingReadRepository.findBookingByBookingIdAndIsDeletedFalse(command.id());
        if (existBooking != null) {
            throw new BookingAlreadyExistException();
        }

        BookingDocument bookingDocument = Mappings.toBookingDocument(command);

        bookingReadRepository.save(bookingDocument);

        return Unit.VALUE;
    }
}
