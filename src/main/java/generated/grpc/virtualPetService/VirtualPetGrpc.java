package generated.grpc.virtualPetService;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: VirtualPetService.proto")
public final class VirtualPetGrpc {

  private VirtualPetGrpc() {}

  public static final String SERVICE_NAME = "virtualPetService.VirtualPet";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.virtualPetService.VirtualPetRequest,
      generated.grpc.virtualPetService.VirtualPetReply> getGetPetStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetPetStatus",
      requestType = generated.grpc.virtualPetService.VirtualPetRequest.class,
      responseType = generated.grpc.virtualPetService.VirtualPetReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.virtualPetService.VirtualPetRequest,
      generated.grpc.virtualPetService.VirtualPetReply> getGetPetStatusMethod() {
    io.grpc.MethodDescriptor<generated.grpc.virtualPetService.VirtualPetRequest, generated.grpc.virtualPetService.VirtualPetReply> getGetPetStatusMethod;
    if ((getGetPetStatusMethod = VirtualPetGrpc.getGetPetStatusMethod) == null) {
      synchronized (VirtualPetGrpc.class) {
        if ((getGetPetStatusMethod = VirtualPetGrpc.getGetPetStatusMethod) == null) {
          VirtualPetGrpc.getGetPetStatusMethod = getGetPetStatusMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.virtualPetService.VirtualPetRequest, generated.grpc.virtualPetService.VirtualPetReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "virtualPetService.VirtualPet", "GetPetStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.virtualPetService.VirtualPetRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.virtualPetService.VirtualPetReply.getDefaultInstance()))
                  .setSchemaDescriptor(new VirtualPetMethodDescriptorSupplier("GetPetStatus"))
                  .build();
          }
        }
     }
     return getGetPetStatusMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static VirtualPetStub newStub(io.grpc.Channel channel) {
    return new VirtualPetStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VirtualPetBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new VirtualPetBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static VirtualPetFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new VirtualPetFutureStub(channel);
  }

  /**
   */
  public static abstract class VirtualPetImplBase implements io.grpc.BindableService {

    /**
     */
    public void getPetStatus(generated.grpc.virtualPetService.VirtualPetRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.virtualPetService.VirtualPetReply> responseObserver) {
      asyncUnimplementedUnaryCall(getGetPetStatusMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetPetStatusMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.virtualPetService.VirtualPetRequest,
                generated.grpc.virtualPetService.VirtualPetReply>(
                  this, METHODID_GET_PET_STATUS)))
          .build();
    }
  }

  /**
   */
  public static final class VirtualPetStub extends io.grpc.stub.AbstractStub<VirtualPetStub> {
    private VirtualPetStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VirtualPetStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VirtualPetStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VirtualPetStub(channel, callOptions);
    }

    /**
     */
    public void getPetStatus(generated.grpc.virtualPetService.VirtualPetRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.virtualPetService.VirtualPetReply> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getGetPetStatusMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class VirtualPetBlockingStub extends io.grpc.stub.AbstractStub<VirtualPetBlockingStub> {
    private VirtualPetBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VirtualPetBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VirtualPetBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VirtualPetBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<generated.grpc.virtualPetService.VirtualPetReply> getPetStatus(
        generated.grpc.virtualPetService.VirtualPetRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getGetPetStatusMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class VirtualPetFutureStub extends io.grpc.stub.AbstractStub<VirtualPetFutureStub> {
    private VirtualPetFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private VirtualPetFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VirtualPetFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new VirtualPetFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GET_PET_STATUS = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final VirtualPetImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(VirtualPetImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_PET_STATUS:
          serviceImpl.getPetStatus((generated.grpc.virtualPetService.VirtualPetRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.virtualPetService.VirtualPetReply>) responseObserver);
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

  private static abstract class VirtualPetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VirtualPetBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.virtualPetService.VirtualPetProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("VirtualPet");
    }
  }

  private static final class VirtualPetFileDescriptorSupplier
      extends VirtualPetBaseDescriptorSupplier {
    VirtualPetFileDescriptorSupplier() {}
  }

  private static final class VirtualPetMethodDescriptorSupplier
      extends VirtualPetBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    VirtualPetMethodDescriptorSupplier(String methodName) {
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
      synchronized (VirtualPetGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new VirtualPetFileDescriptorSupplier())
              .addMethod(getGetPetStatusMethod())
              .build();
        }
      }
    }
    return result;
  }
}
