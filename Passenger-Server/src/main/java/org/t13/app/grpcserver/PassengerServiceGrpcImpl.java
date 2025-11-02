package org.t13.app.grpcserver;

import org.t13.app.foundation.mediator.abstractions.IMediator;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.t13.app.passengers.dtos.PassengerDto;
import org.t13.app.passengers.features.getpassengerbyid.GetPassengerByIdQuery;
import passenger.Passenger;
import passenger.PassengerServiceGrpc;
import java.util.UUID;

import static org.t13.app.passengers.features.Mappings.toPassengerResponseDtoGrpc;

@GrpcService
public class PassengerServiceGrpcImpl extends PassengerServiceGrpc.PassengerServiceImplBase {

    private final IMediator mediator;

    public PassengerServiceGrpcImpl(IMediator mediator) {
        this.mediator = mediator;
    }


    @Override
    public void getById(Passenger.PassengerRequestDto request, StreamObserver<Passenger.PassengerResponseDto> responseObserver) {

        PassengerDto result = mediator.send(new GetPassengerByIdQuery(UUID.fromString(request.getId())));
        Passenger.PassengerResponseDto passengerResponseDtoGrpc = toPassengerResponseDtoGrpc(result);

        responseObserver.onNext(passengerResponseDtoGrpc);
        responseObserver.onCompleted();
    }
}
