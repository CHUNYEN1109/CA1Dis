package generated.grpc.productTrackService;

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
 * <pre>
 * The service definition
 * Type of Service : bidi Stream type 
 *Function: This service uses to fetch a stream of product information including amount of carbon dioxide, material //type through  a stream of barcodes or QR codes.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: PurchaseService.proto")
public final class ProductTrackGrpc {

  private ProductTrackGrpc() {}

  public static final String SERVICE_NAME = "productTrackService.ProductTrack";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.productTrackService.ProductRequest,
      generated.grpc.productTrackService.ProductReply> getPurchaseTrackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "PurchaseTrack",
      requestType = generated.grpc.productTrackService.ProductRequest.class,
      responseType = generated.grpc.productTrackService.ProductReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.productTrackService.ProductRequest,
      generated.grpc.productTrackService.ProductReply> getPurchaseTrackMethod() {
    io.grpc.MethodDescriptor<generated.grpc.productTrackService.ProductRequest, generated.grpc.productTrackService.ProductReply> getPurchaseTrackMethod;
    if ((getPurchaseTrackMethod = ProductTrackGrpc.getPurchaseTrackMethod) == null) {
      synchronized (ProductTrackGrpc.class) {
        if ((getPurchaseTrackMethod = ProductTrackGrpc.getPurchaseTrackMethod) == null) {
          ProductTrackGrpc.getPurchaseTrackMethod = getPurchaseTrackMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.productTrackService.ProductRequest, generated.grpc.productTrackService.ProductReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "productTrackService.ProductTrack", "PurchaseTrack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.productTrackService.ProductRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.productTrackService.ProductReply.getDefaultInstance()))
                  .setSchemaDescriptor(new ProductTrackMethodDescriptorSupplier("PurchaseTrack"))
                  .build();
          }
        }
     }
     return getPurchaseTrackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ProductTrackStub newStub(io.grpc.Channel channel) {
    return new ProductTrackStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ProductTrackBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ProductTrackBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ProductTrackFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ProductTrackFutureStub(channel);
  }

  /**
   * <pre>
   * The service definition
   * Type of Service : bidi Stream type 
   *Function: This service uses to fetch a stream of product information including amount of carbon dioxide, material //type through  a stream of barcodes or QR codes.
   * </pre>
   */
  public static abstract class ProductTrackImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * get information of product.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.productTrackService.ProductRequest> purchaseTrack(
        io.grpc.stub.StreamObserver<generated.grpc.productTrackService.ProductReply> responseObserver) {
      return asyncUnimplementedStreamingCall(getPurchaseTrackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getPurchaseTrackMethod(),
            asyncBidiStreamingCall(
              new MethodHandlers<
                generated.grpc.productTrackService.ProductRequest,
                generated.grpc.productTrackService.ProductReply>(
                  this, METHODID_PURCHASE_TRACK)))
          .build();
    }
  }

  /**
   * <pre>
   * The service definition
   * Type of Service : bidi Stream type 
   *Function: This service uses to fetch a stream of product information including amount of carbon dioxide, material //type through  a stream of barcodes or QR codes.
   * </pre>
   */
  public static final class ProductTrackStub extends io.grpc.stub.AbstractStub<ProductTrackStub> {
    private ProductTrackStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductTrackStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductTrackStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductTrackStub(channel, callOptions);
    }

    /**
     * <pre>
     * get information of product.
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.productTrackService.ProductRequest> purchaseTrack(
        io.grpc.stub.StreamObserver<generated.grpc.productTrackService.ProductReply> responseObserver) {
      return asyncBidiStreamingCall(
          getChannel().newCall(getPurchaseTrackMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * The service definition
   * Type of Service : bidi Stream type 
   *Function: This service uses to fetch a stream of product information including amount of carbon dioxide, material //type through  a stream of barcodes or QR codes.
   * </pre>
   */
  public static final class ProductTrackBlockingStub extends io.grpc.stub.AbstractStub<ProductTrackBlockingStub> {
    private ProductTrackBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductTrackBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductTrackBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductTrackBlockingStub(channel, callOptions);
    }
  }

  /**
   * <pre>
   * The service definition
   * Type of Service : bidi Stream type 
   *Function: This service uses to fetch a stream of product information including amount of carbon dioxide, material //type through  a stream of barcodes or QR codes.
   * </pre>
   */
  public static final class ProductTrackFutureStub extends io.grpc.stub.AbstractStub<ProductTrackFutureStub> {
    private ProductTrackFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ProductTrackFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ProductTrackFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ProductTrackFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_PURCHASE_TRACK = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ProductTrackImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ProductTrackImplBase serviceImpl, int methodId) {
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
        case METHODID_PURCHASE_TRACK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.purchaseTrack(
              (io.grpc.stub.StreamObserver<generated.grpc.productTrackService.ProductReply>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ProductTrackBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ProductTrackBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.productTrackService.ProductTrackServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ProductTrack");
    }
  }

  private static final class ProductTrackFileDescriptorSupplier
      extends ProductTrackBaseDescriptorSupplier {
    ProductTrackFileDescriptorSupplier() {}
  }

  private static final class ProductTrackMethodDescriptorSupplier
      extends ProductTrackBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ProductTrackMethodDescriptorSupplier(String methodName) {
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
      synchronized (ProductTrackGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ProductTrackFileDescriptorSupplier())
              .addMethod(getPurchaseTrackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
