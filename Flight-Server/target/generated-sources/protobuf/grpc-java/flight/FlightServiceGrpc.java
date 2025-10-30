package flight;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: flight.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class FlightServiceGrpc {

  private FlightServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "flight.FlightService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<flight.Flight.GetByIdRequestDto,
      flight.Flight.FlightResponseDto> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = flight.Flight.GetByIdRequestDto.class,
      responseType = flight.Flight.FlightResponseDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<flight.Flight.GetByIdRequestDto,
      flight.Flight.FlightResponseDto> getGetByIdMethod() {
    io.grpc.MethodDescriptor<flight.Flight.GetByIdRequestDto, flight.Flight.FlightResponseDto> getGetByIdMethod;
    if ((getGetByIdMethod = FlightServiceGrpc.getGetByIdMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetByIdMethod = FlightServiceGrpc.getGetByIdMethod) == null) {
          FlightServiceGrpc.getGetByIdMethod = getGetByIdMethod =
              io.grpc.MethodDescriptor.<flight.Flight.GetByIdRequestDto, flight.Flight.FlightResponseDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.GetByIdRequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.FlightResponseDto.getDefaultInstance()))
              .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("GetById"))
              .build();
        }
      }
    }
    return getGetByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<flight.Flight.GetAvailableSeatsRequestDto,
      flight.Flight.GetAvailableSeatsResponseDto> getGetAvailableSeatsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetAvailableSeats",
      requestType = flight.Flight.GetAvailableSeatsRequestDto.class,
      responseType = flight.Flight.GetAvailableSeatsResponseDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<flight.Flight.GetAvailableSeatsRequestDto,
      flight.Flight.GetAvailableSeatsResponseDto> getGetAvailableSeatsMethod() {
    io.grpc.MethodDescriptor<flight.Flight.GetAvailableSeatsRequestDto, flight.Flight.GetAvailableSeatsResponseDto> getGetAvailableSeatsMethod;
    if ((getGetAvailableSeatsMethod = FlightServiceGrpc.getGetAvailableSeatsMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getGetAvailableSeatsMethod = FlightServiceGrpc.getGetAvailableSeatsMethod) == null) {
          FlightServiceGrpc.getGetAvailableSeatsMethod = getGetAvailableSeatsMethod =
              io.grpc.MethodDescriptor.<flight.Flight.GetAvailableSeatsRequestDto, flight.Flight.GetAvailableSeatsResponseDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAvailableSeats"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.GetAvailableSeatsRequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.GetAvailableSeatsResponseDto.getDefaultInstance()))
              .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("GetAvailableSeats"))
              .build();
        }
      }
    }
    return getGetAvailableSeatsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<flight.Flight.ReserveSeatRequestDto,
      flight.Flight.SeatResponseDto> getReserveSeatMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReserveSeat",
      requestType = flight.Flight.ReserveSeatRequestDto.class,
      responseType = flight.Flight.SeatResponseDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<flight.Flight.ReserveSeatRequestDto,
      flight.Flight.SeatResponseDto> getReserveSeatMethod() {
    io.grpc.MethodDescriptor<flight.Flight.ReserveSeatRequestDto, flight.Flight.SeatResponseDto> getReserveSeatMethod;
    if ((getReserveSeatMethod = FlightServiceGrpc.getReserveSeatMethod) == null) {
      synchronized (FlightServiceGrpc.class) {
        if ((getReserveSeatMethod = FlightServiceGrpc.getReserveSeatMethod) == null) {
          FlightServiceGrpc.getReserveSeatMethod = getReserveSeatMethod =
              io.grpc.MethodDescriptor.<flight.Flight.ReserveSeatRequestDto, flight.Flight.SeatResponseDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ReserveSeat"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.ReserveSeatRequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  flight.Flight.SeatResponseDto.getDefaultInstance()))
              .setSchemaDescriptor(new FlightServiceMethodDescriptorSupplier("ReserveSeat"))
              .build();
        }
      }
    }
    return getReserveSeatMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FlightServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceStub>() {
        @java.lang.Override
        public FlightServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceStub(channel, callOptions);
        }
      };
    return FlightServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FlightServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceBlockingStub>() {
        @java.lang.Override
        public FlightServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceBlockingStub(channel, callOptions);
        }
      };
    return FlightServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FlightServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FlightServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FlightServiceFutureStub>() {
        @java.lang.Override
        public FlightServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FlightServiceFutureStub(channel, callOptions);
        }
      };
    return FlightServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getById(flight.Flight.GetByIdRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.FlightResponseDto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }

    /**
     */
    default void getAvailableSeats(flight.Flight.GetAvailableSeatsRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.GetAvailableSeatsResponseDto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAvailableSeatsMethod(), responseObserver);
    }

    /**
     */
    default void reserveSeat(flight.Flight.ReserveSeatRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.SeatResponseDto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getReserveSeatMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FlightService.
   */
  public static abstract class FlightServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return FlightServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service FlightService.
   */
  public static final class FlightServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FlightServiceStub> {
    private FlightServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(flight.Flight.GetByIdRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.FlightResponseDto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAvailableSeats(flight.Flight.GetAvailableSeatsRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.GetAvailableSeatsResponseDto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetAvailableSeatsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void reserveSeat(flight.Flight.ReserveSeatRequestDto request,
        io.grpc.stub.StreamObserver<flight.Flight.SeatResponseDto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service FlightService.
   */
  public static final class FlightServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FlightServiceBlockingStub> {
    private FlightServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public flight.Flight.FlightResponseDto getById(flight.Flight.GetByIdRequestDto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public flight.Flight.GetAvailableSeatsResponseDto getAvailableSeats(flight.Flight.GetAvailableSeatsRequestDto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetAvailableSeatsMethod(), getCallOptions(), request);
    }

    /**
     */
    public flight.Flight.SeatResponseDto reserveSeat(flight.Flight.ReserveSeatRequestDto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getReserveSeatMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service FlightService.
   */
  public static final class FlightServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FlightServiceFutureStub> {
    private FlightServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FlightServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FlightServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<flight.Flight.FlightResponseDto> getById(
        flight.Flight.GetByIdRequestDto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<flight.Flight.GetAvailableSeatsResponseDto> getAvailableSeats(
        flight.Flight.GetAvailableSeatsRequestDto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetAvailableSeatsMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<flight.Flight.SeatResponseDto> reserveSeat(
        flight.Flight.ReserveSeatRequestDto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getReserveSeatMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ID = 0;
  private static final int METHODID_GET_AVAILABLE_SEATS = 1;
  private static final int METHODID_RESERVE_SEAT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_BY_ID:
          serviceImpl.getById((flight.Flight.GetByIdRequestDto) request,
              (io.grpc.stub.StreamObserver<flight.Flight.FlightResponseDto>) responseObserver);
          break;
        case METHODID_GET_AVAILABLE_SEATS:
          serviceImpl.getAvailableSeats((flight.Flight.GetAvailableSeatsRequestDto) request,
              (io.grpc.stub.StreamObserver<flight.Flight.GetAvailableSeatsResponseDto>) responseObserver);
          break;
        case METHODID_RESERVE_SEAT:
          serviceImpl.reserveSeat((flight.Flight.ReserveSeatRequestDto) request,
              (io.grpc.stub.StreamObserver<flight.Flight.SeatResponseDto>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getGetByIdMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              flight.Flight.GetByIdRequestDto,
              flight.Flight.FlightResponseDto>(
                service, METHODID_GET_BY_ID)))
        .addMethod(
          getGetAvailableSeatsMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              flight.Flight.GetAvailableSeatsRequestDto,
              flight.Flight.GetAvailableSeatsResponseDto>(
                service, METHODID_GET_AVAILABLE_SEATS)))
        .addMethod(
          getReserveSeatMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              flight.Flight.ReserveSeatRequestDto,
              flight.Flight.SeatResponseDto>(
                service, METHODID_RESERVE_SEAT)))
        .build();
  }

  private static abstract class FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FlightServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return flight.Flight.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FlightService");
    }
  }

  private static final class FlightServiceFileDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier {
    FlightServiceFileDescriptorSupplier() {}
  }

  private static final class FlightServiceMethodDescriptorSupplier
      extends FlightServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FlightServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (FlightServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FlightServiceFileDescriptorSupplier())
              .addMethod(getGetByIdMethod())
              .addMethod(getGetAvailableSeatsMethod())
              .addMethod(getReserveSeatMethod())
              .build();
        }
      }
    }
    return result;
  }
}
