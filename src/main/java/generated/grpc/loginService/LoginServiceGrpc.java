package generated.grpc.loginService;

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
 * Unary type
 * send id and password; return confirmation
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: LoginService.proto")
public final class LoginServiceGrpc {

  private LoginServiceGrpc() {}

  public static final String SERVICE_NAME = "loginService.LoginService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.loginService.LoginRequest,
      generated.grpc.loginService.LoginResponse> getLoginSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LoginSystem",
      requestType = generated.grpc.loginService.LoginRequest.class,
      responseType = generated.grpc.loginService.LoginResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.loginService.LoginRequest,
      generated.grpc.loginService.LoginResponse> getLoginSystemMethod() {
    io.grpc.MethodDescriptor<generated.grpc.loginService.LoginRequest, generated.grpc.loginService.LoginResponse> getLoginSystemMethod;
    if ((getLoginSystemMethod = LoginServiceGrpc.getLoginSystemMethod) == null) {
      synchronized (LoginServiceGrpc.class) {
        if ((getLoginSystemMethod = LoginServiceGrpc.getLoginSystemMethod) == null) {
          LoginServiceGrpc.getLoginSystemMethod = getLoginSystemMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.loginService.LoginRequest, generated.grpc.loginService.LoginResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "loginService.LoginService", "LoginSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.loginService.LoginRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.loginService.LoginResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LoginServiceMethodDescriptorSupplier("LoginSystem"))
                  .build();
          }
        }
     }
     return getLoginSystemMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.loginService.LogoutRequest,
      generated.grpc.loginService.LogoutResponse> getLogoutSystemMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LogoutSystem",
      requestType = generated.grpc.loginService.LogoutRequest.class,
      responseType = generated.grpc.loginService.LogoutResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.loginService.LogoutRequest,
      generated.grpc.loginService.LogoutResponse> getLogoutSystemMethod() {
    io.grpc.MethodDescriptor<generated.grpc.loginService.LogoutRequest, generated.grpc.loginService.LogoutResponse> getLogoutSystemMethod;
    if ((getLogoutSystemMethod = LoginServiceGrpc.getLogoutSystemMethod) == null) {
      synchronized (LoginServiceGrpc.class) {
        if ((getLogoutSystemMethod = LoginServiceGrpc.getLogoutSystemMethod) == null) {
          LoginServiceGrpc.getLogoutSystemMethod = getLogoutSystemMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.loginService.LogoutRequest, generated.grpc.loginService.LogoutResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "loginService.LoginService", "LogoutSystem"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.loginService.LogoutRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.loginService.LogoutResponse.getDefaultInstance()))
                  .setSchemaDescriptor(new LoginServiceMethodDescriptorSupplier("LogoutSystem"))
                  .build();
          }
        }
     }
     return getLogoutSystemMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LoginServiceStub newStub(io.grpc.Channel channel) {
    return new LoginServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LoginServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LoginServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LoginServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LoginServiceFutureStub(channel);
  }

  /**
   * <pre>
   * The service definition 
   * Unary type
   * send id and password; return confirmation
   * </pre>
   */
  public static abstract class LoginServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * to confirm an account, returns an confirmation
     * </pre>
     */
    public void loginSystem(generated.grpc.loginService.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.loginService.LoginResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLoginSystemMethod(), responseObserver);
    }

    /**
     */
    public void logoutSystem(generated.grpc.loginService.LogoutRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.loginService.LogoutResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getLogoutSystemMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getLoginSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.loginService.LoginRequest,
                generated.grpc.loginService.LoginResponse>(
                  this, METHODID_LOGIN_SYSTEM)))
          .addMethod(
            getLogoutSystemMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.loginService.LogoutRequest,
                generated.grpc.loginService.LogoutResponse>(
                  this, METHODID_LOGOUT_SYSTEM)))
          .build();
    }
  }

  /**
   * <pre>
   * The service definition 
   * Unary type
   * send id and password; return confirmation
   * </pre>
   */
  public static final class LoginServiceStub extends io.grpc.stub.AbstractStub<LoginServiceStub> {
    private LoginServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * to confirm an account, returns an confirmation
     * </pre>
     */
    public void loginSystem(generated.grpc.loginService.LoginRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.loginService.LoginResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLoginSystemMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void logoutSystem(generated.grpc.loginService.LogoutRequest request,
        io.grpc.stub.StreamObserver<generated.grpc.loginService.LogoutResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getLogoutSystemMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   * The service definition 
   * Unary type
   * send id and password; return confirmation
   * </pre>
   */
  public static final class LoginServiceBlockingStub extends io.grpc.stub.AbstractStub<LoginServiceBlockingStub> {
    private LoginServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * to confirm an account, returns an confirmation
     * </pre>
     */
    public generated.grpc.loginService.LoginResponse loginSystem(generated.grpc.loginService.LoginRequest request) {
      return blockingUnaryCall(
          getChannel(), getLoginSystemMethod(), getCallOptions(), request);
    }

    /**
     */
    public generated.grpc.loginService.LogoutResponse logoutSystem(generated.grpc.loginService.LogoutRequest request) {
      return blockingUnaryCall(
          getChannel(), getLogoutSystemMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * The service definition 
   * Unary type
   * send id and password; return confirmation
   * </pre>
   */
  public static final class LoginServiceFutureStub extends io.grpc.stub.AbstractStub<LoginServiceFutureStub> {
    private LoginServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LoginServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LoginServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LoginServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * to confirm an account, returns an confirmation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.loginService.LoginResponse> loginSystem(
        generated.grpc.loginService.LoginRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLoginSystemMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.loginService.LogoutResponse> logoutSystem(
        generated.grpc.loginService.LogoutRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getLogoutSystemMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LOGIN_SYSTEM = 0;
  private static final int METHODID_LOGOUT_SYSTEM = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LoginServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LoginServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LOGIN_SYSTEM:
          serviceImpl.loginSystem((generated.grpc.loginService.LoginRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.loginService.LoginResponse>) responseObserver);
          break;
        case METHODID_LOGOUT_SYSTEM:
          serviceImpl.logoutSystem((generated.grpc.loginService.LogoutRequest) request,
              (io.grpc.stub.StreamObserver<generated.grpc.loginService.LogoutResponse>) responseObserver);
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

  private static abstract class LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LoginServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.loginService.LoginServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LoginService");
    }
  }

  private static final class LoginServiceFileDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier {
    LoginServiceFileDescriptorSupplier() {}
  }

  private static final class LoginServiceMethodDescriptorSupplier
      extends LoginServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LoginServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (LoginServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LoginServiceFileDescriptorSupplier())
              .addMethod(getLoginSystemMethod())
              .addMethod(getLogoutSystemMethod())
              .build();
        }
      }
    }
    return result;
  }
}
