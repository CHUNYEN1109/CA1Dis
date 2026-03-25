package generated.grpc.sustainableActivityService;

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
    comments = "Source: SustainableActivityService.proto")
public final class ActivityTrackGrpc {

  private ActivityTrackGrpc() {}

  public static final String SERVICE_NAME = "sustainableActivityService.ActivityTrack";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.sustainableActivityService.ActivityRequest,
      generated.grpc.sustainableActivityService.ActivityReply> getTrackActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackActivity",
      requestType = generated.grpc.sustainableActivityService.ActivityRequest.class,
      responseType = generated.grpc.sustainableActivityService.ActivityReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.sustainableActivityService.ActivityRequest,
      generated.grpc.sustainableActivityService.ActivityReply> getTrackActivityMethod() {
    io.grpc.MethodDescriptor<generated.grpc.sustainableActivityService.ActivityRequest, generated.grpc.sustainableActivityService.ActivityReply> getTrackActivityMethod;
    if ((getTrackActivityMethod = ActivityTrackGrpc.getTrackActivityMethod) == null) {
      synchronized (ActivityTrackGrpc.class) {
        if ((getTrackActivityMethod = ActivityTrackGrpc.getTrackActivityMethod) == null) {
          ActivityTrackGrpc.getTrackActivityMethod = getTrackActivityMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.sustainableActivityService.ActivityRequest, generated.grpc.sustainableActivityService.ActivityReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "sustainableActivityService.ActivityTrack", "TrackActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sustainableActivityService.ActivityRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.sustainableActivityService.ActivityReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ActivityTrackMethodDescriptorSupplier("TrackActivity"))
                  .build();
          }
        }
     }
     return getTrackActivityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ActivityTrackStub newStub(io.grpc.Channel channel) {
    return new ActivityTrackStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ActivityTrackBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ActivityTrackBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ActivityTrackFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ActivityTrackFutureStub(channel);
  }

  /**
   */
  public static abstract class ActivityTrackImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * get information of product.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.sustainableActivityService.ActivityRequest> trackActivity(
        io.grpc.stub.StreamObserver<generated.grpc.sustainableActivityService.ActivityReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getTrackActivityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getTrackActivityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.sustainableActivityService.ActivityRequest,
                generated.grpc.sustainableActivityService.ActivityReply>(
                  this, METHODID_TRACK_ACTIVITY)))
          .build();
    }
  }

  /**
   */
  public static final class ActivityTrackStub extends io.grpc.stub.AbstractStub<ActivityTrackStub> {
    private ActivityTrackStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActivityTrackStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActivityTrackStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActivityTrackStub(channel, callOptions);
    }

    /**
     * <pre>
     * get information of product.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.sustainableActivityService.ActivityRequest> trackActivity(
        io.grpc.stub.StreamObserver<generated.grpc.sustainableActivityService.ActivityReply> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getTrackActivityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class ActivityTrackBlockingStub extends io.grpc.stub.AbstractStub<ActivityTrackBlockingStub> {
    private ActivityTrackBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActivityTrackBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActivityTrackBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActivityTrackBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class ActivityTrackFutureStub extends io.grpc.stub.AbstractStub<ActivityTrackFutureStub> {
    private ActivityTrackFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ActivityTrackFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ActivityTrackFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ActivityTrackFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_TRACK_ACTIVITY = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ActivityTrackImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ActivityTrackImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_TRACK_ACTIVITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.trackActivity(
              (io.grpc.stub.StreamObserver<generated.grpc.sustainableActivityService.ActivityReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ActivityTrackBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ActivityTrackBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.sustainableActivityService.SustainableActivityProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ActivityTrack");
    }
  }

  private static final class ActivityTrackFileDescriptorSupplier
      extends ActivityTrackBaseDescriptorSupplier {
    ActivityTrackFileDescriptorSupplier() {}
  }

  private static final class ActivityTrackMethodDescriptorSupplier
      extends ActivityTrackBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ActivityTrackMethodDescriptorSupplier(String methodName) {
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
      synchronized (ActivityTrackGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ActivityTrackFileDescriptorSupplier())
              .addMethod(getTrackActivityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
