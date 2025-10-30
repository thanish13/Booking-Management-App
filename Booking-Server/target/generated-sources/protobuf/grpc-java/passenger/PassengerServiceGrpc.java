package passenger;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.57.2)",
    comments = "Source: passenger.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class PassengerServiceGrpc {

  private PassengerServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "passenger.PassengerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<passenger.Passenger.PassengerRequestDto,
      passenger.Passenger.PassengerResponseDto> getGetByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetById",
      requestType = passenger.Passenger.PassengerRequestDto.class,
      responseType = passenger.Passenger.PassengerResponseDto.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<passenger.Passenger.PassengerRequestDto,
      passenger.Passenger.PassengerResponseDto> getGetByIdMethod() {
    io.grpc.MethodDescriptor<passenger.Passenger.PassengerRequestDto, passenger.Passenger.PassengerResponseDto> getGetByIdMethod;
    if ((getGetByIdMethod = PassengerServiceGrpc.getGetByIdMethod) == null) {
      synchronized (PassengerServiceGrpc.class) {
        if ((getGetByIdMethod = PassengerServiceGrpc.getGetByIdMethod) == null) {
          PassengerServiceGrpc.getGetByIdMethod = getGetByIdMethod =
              io.grpc.MethodDescriptor.<passenger.Passenger.PassengerRequestDto, passenger.Passenger.PassengerResponseDto>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  passenger.Passenger.PassengerRequestDto.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  passenger.Passenger.PassengerResponseDto.getDefaultInstance()))
              .setSchemaDescriptor(new PassengerServiceMethodDescriptorSupplier("GetById"))
              .build();
        }
      }
    }
    return getGetByIdMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PassengerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PassengerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PassengerServiceStub>() {
        @java.lang.Override
        public PassengerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PassengerServiceStub(channel, callOptions);
        }
      };
    return PassengerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PassengerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PassengerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PassengerServiceBlockingStub>() {
        @java.lang.Override
        public PassengerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PassengerServiceBlockingStub(channel, callOptions);
        }
      };
    return PassengerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PassengerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<PassengerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<PassengerServiceFutureStub>() {
        @java.lang.Override
        public PassengerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new PassengerServiceFutureStub(channel, callOptions);
        }
      };
    return PassengerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void getById(passenger.Passenger.PassengerRequestDto request,
        io.grpc.stub.StreamObserver<passenger.Passenger.PassengerResponseDto> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service PassengerService.
   */
  public static abstract class PassengerServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return PassengerServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service PassengerService.
   */
  public static final class PassengerServiceStub
      extends io.grpc.stub.AbstractAsyncStub<PassengerServiceStub> {
    private PassengerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PassengerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PassengerServiceStub(channel, callOptions);
    }

    /**
     */
    public void getById(passenger.Passenger.PassengerRequestDto request,
        io.grpc.stub.StreamObserver<passenger.Passenger.PassengerResponseDto> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service PassengerService.
   */
  public static final class PassengerServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<PassengerServiceBlockingStub> {
    private PassengerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PassengerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PassengerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public passenger.Passenger.PassengerResponseDto getById(passenger.Passenger.PassengerRequestDto request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetByIdMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service PassengerService.
   */
  public static final class PassengerServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<PassengerServiceFutureStub> {
    private PassengerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PassengerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new PassengerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<passenger.Passenger.PassengerResponseDto> getById(
        passenger.Passenger.PassengerRequestDto request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_BY_ID = 0;

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
          serviceImpl.getById((passenger.Passenger.PassengerRequestDto) request,
              (io.grpc.stub.StreamObserver<passenger.Passenger.PassengerResponseDto>) responseObserver);
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
              passenger.Passenger.PassengerRequestDto,
              passenger.Passenger.PassengerResponseDto>(
                service, METHODID_GET_BY_ID)))
        .build();
  }

  private static abstract class PassengerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PassengerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return passenger.Passenger.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PassengerService");
    }
  }

  private static final class PassengerServiceFileDescriptorSupplier
      extends PassengerServiceBaseDescriptorSupplier {
    PassengerServiceFileDescriptorSupplier() {}
  }

  private static final class PassengerServiceMethodDescriptorSupplier
      extends PassengerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    PassengerServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (PassengerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PassengerServiceFileDescriptorSupplier())
              .addMethod(getGetByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
