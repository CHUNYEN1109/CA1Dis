/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userAndServer;
// IO and util tools
import dissys.ca1dis.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.StatusRuntimeException;
import java.util.logging.Logger;

// Service, Request and Response
// Login
import generated.grpc.loginService.LoginServiceGrpc;
import generated.grpc.loginService.LoginRequest;
import generated.grpc.loginService.LoginResponse;
import generated.grpc.loginService.LoginServiceGrpc.LoginServiceBlockingStub;
// Logout
import generated.grpc.loginService.LogoutRequest;
import generated.grpc.loginService.LogoutResponse;
import generated.grpc.productTrackService.ProductReply;
import generated.grpc.productTrackService.ProductRequest;
// Producttrrack
import generated.grpc.productTrackService.ProductTrackGrpc.ProductTrackStub;
import generated.grpc.productTrackService.ProductTrackGrpc;
import generated.grpc.sustainableActivityService.ActivityReply;
import generated.grpc.sustainableActivityService.ActivityRequest;
// Sustainable Activity
import generated.grpc.sustainableActivityService.ActivityTrackGrpc.ActivityTrackStub;
import generated.grpc.sustainableActivityService.ActivityTrackGrpc;

// VirtualPet
import generated.grpc.virtualPetService.VirtualPetGrpc.VirtualPetStub;
import generated.grpc.virtualPetService.VirtualPetGrpc;
import generated.grpc.virtualPetService.VirtualPetReply;
import generated.grpc.virtualPetService.VirtualPetRequest;


import java.util.function.Consumer;

// jmdns
import jmdns.ServiceDiscovery;
import javax.jmdns.ServiceInfo;

import dissys.ca1dis.LoginSystemGui;
/**
 *
 * @author brad1109
 */
public class RCPgameClient implements AutoCloseable {

    private static Logger logger = Logger.getLogger(RCPgameClient.class.getName());

    // channel
    private final ManagedChannel channel;

    // multiple stubs
    private final LoginServiceBlockingStub loginServiceStub;
    private final ProductTrackStub productServiceStub;
    private final ActivityTrackStub activityTrackServiceStub;
    private final VirtualPetStub virtualPetStub;

    // Constructor
    public RCPgameClient(String host, int port) throws Exception {
        // put stubs into the channel
        channel = ManagedChannelBuilder.forAddress(host, port).usePlaintext().build();

        loginServiceStub = LoginServiceGrpc.newBlockingStub(channel);
        productServiceStub = ProductTrackGrpc.newStub(channel);
        activityTrackServiceStub = ActivityTrackGrpc.newStub(channel);
        virtualPetStub = VirtualPetGrpc.newStub(channel);

    }

    public static void main(String[] args) throws Exception {

        // Create Discovery intance
        ServiceDiscovery discovery = new ServiceDiscovery("_grpc._tcp.local.", "gameServers");
        ServiceInfo info = discovery.discoverService(3000);

        String host = (info != null && info.getHostAddresses().length > 0)
                ? info.getHostAddresses()[0]
                : "localhost";
        int port = (info != null) ? info.getPort() : 50051;

        System.out.println("Discovered gRPC host=" + host + ", port=" + port);

        RCPgameClient client = new RCPgameClient(host, port);
        // open login Gui
        java.awt.EventQueue.invokeLater(() -> new LoginSystemGui(client).setVisible(true));

    }

    // Type: Service Stream 
    // response => StreamObserver 
    // 1 -> n
    public void getVirtualStatus(Consumer<VirtualPetReply> onNext,
            Consumer<Throwable> onError,
            Runnable onCompleted) {
        System.out.println("Server Streaming Synchronous - getVirtualStatus ");

        VirtualPetRequest request = VirtualPetRequest.newBuilder().build();
        // response observer
        StreamObserver<VirtualPetReply> response = new StreamObserver<VirtualPetReply>() {
            @Override
            public void onNext(VirtualPetReply v) {
                onNext.accept(v);
            }

            @Override
            public void onError(Throwable thrwbl) {
                onError.accept(thrwbl);
            }

            @Override
            public void onCompleted() {
                onCompleted.run();
            }

        };
        // send request 
        virtualPetStub.getPetStatus(request, response);

    }

    // Type: Client Stream
    // Request => StreamObserver
    // n -> 1
    public StreamObserver<ActivityRequest> activityTrack(
            Consumer<ActivityReply> onReply,
            Consumer<Throwable> onError,
            Runnable onCompleted
    ) {
        StreamObserver<ActivityReply> responseObserver = new StreamObserver<ActivityReply>() {
            @Override
            public void onNext(ActivityReply v) {
                onReply.accept(v);
            }

            @Override
            public void onError(Throwable t) {
                onError.accept(t);
            }

            @Override
            public void onCompleted() {
                onCompleted.run();
            }
        };

        // return requestObserver to GUI，for onNext / onCompleted
        return activityTrackServiceStub.trackActivity(responseObserver);
    }

    public void productTrack(String productId,
            Consumer<ProductReply> onNext,
            Consumer<Throwable> onError,
            Runnable onCompleted) {
        // Trracking infomation
        System.out.println("Bi-directional - productTrack ");

        StreamObserver<ProductReply> responseObserver = new StreamObserver<ProductReply>() {
            @Override
            public void onNext(ProductReply v) {
                onNext.accept(v);
            }

            @Override
            public void onError(Throwable thrwbl) {
                onError.accept(thrwbl);
            }

            @Override
            public void onCompleted() {
                onCompleted.run();
            }
        };
        // client opens the interaction using the asynchronous stub 
        // the client passes in its responseObserver and gets back a requestObserver 
        // the client sends requests using onNext() method on the requestObserver 
        // 
        StreamObserver<ProductRequest> requestObserver = productServiceStub.purchaseTrack(responseObserver);
        requestObserver.onNext(ProductRequest.newBuilder().setProductId(productId).build());
        requestObserver.onCompleted();

    }

    public void logOutfunction() {
        try {
            LogoutRequest request = LogoutRequest.newBuilder().build();

            LogoutResponse response = loginServiceStub.logoutSystem(request);

            // Output
            boolean result = response.getConfirmation().getResult();
            String message = response.getConfirmation().getMessage();
            System.out.println("The account logout: " + message + ", " + result);

        } catch (StatusRuntimeException e) {
            // TODO Auto-generated catch block
            System.out.println("gRPC failed: " + e.getStatus());
        }
    }

    public boolean loginfunction(String id, String password) {

        try {

            LoginRequest loginRequest = LoginRequest.newBuilder().setId(id).setPassword(password).build();

            LoginResponse loginResponse = loginServiceStub.loginSystem(loginRequest);

            // Output 
            boolean result = loginResponse.getConfirmation().getResult();
            
            String message = loginResponse.getConfirmation().getMessage();
            System.out.println("ID: " + loginRequest.getId() + ", Password: " + loginRequest.getPassword() + "\nResult: " + result + ", " + message);
            return result;
            
        } catch (StatusRuntimeException e) {
            // TODO Auto-generated catch block
            System.out.println("gRPC failed: " + e.getStatus());
            return false;
        }
    }

    @Override
    public void close() throws Exception {
        channel.shutdown();
    }

}
