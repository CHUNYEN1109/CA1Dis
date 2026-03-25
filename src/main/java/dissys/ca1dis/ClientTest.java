/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dissys.ca1dis;

import data.product.Product;
import data.product.ProductMap;
import io.grpc.StatusRuntimeException;

// Login
import generated.grpc.loginService.LoginServiceGrpc;
import generated.grpc.loginService.LoginRequest;
import generated.grpc.loginService.LoginResponse;
import generated.grpc.loginService.LoginServiceGrpc.LoginServiceBlockingStub;
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
import generated.grpc.sustainableActivityService.ActivityType;

// VirtualPet
import generated.grpc.virtualPetService.VirtualPetGrpc.VirtualPetStub;
import generated.grpc.virtualPetService.VirtualPetGrpc;
import generated.grpc.virtualPetService.VirtualPetReply;
import generated.grpc.virtualPetService.VirtualPetRequest;

// IO and util tools
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import io.grpc.StatusRuntimeException;
import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 *
 * @author brad1109
 */
public class ClientTest {

    Logger logger = Logger.getLogger(ClientTest.class.getName());

    // channel
    private ManagedChannel channel;
    // stubs 
    private final LoginServiceBlockingStub loginStub;
    private final ProductTrackStub productServiceStub;
    private final ActivityTrackStub activityTrackStub;
    private final VirtualPetStub virtualPetStub;

    // constructor
    ClientTest(String name, int port) {
        // build channel
        channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        // wrap stub into chanell
        loginStub = LoginServiceGrpc.newBlockingStub(channel);
        productServiceStub = ProductTrackGrpc.newStub(channel);
        activityTrackStub = ActivityTrackGrpc.newStub(channel);
        virtualPetStub = VirtualPetGrpc.newStub(channel);
    }

    public static void main(String[] args) throws Exception {
        // ClientTest instance
        ClientTest clientTest = new ClientTest("localhost", 50051);
        //set request
        // requeest is empty 
        // invoke
        try{
            clientTest.getVirtualStatus();
        }finally{
            clientTest.shutdown();
        }
        
        // close 
    }

    // Type: Service Stream 
    // response => StreamObserver 
    // 1 -> n
    public void getVirtualStatus()throws InterruptedException {
        System.out.println("Server Streaming - getVirtualStatus ");

        CountDownLatch latch = new CountDownLatch(1);

        VirtualPetRequest request = VirtualPetRequest.newBuilder().build();
        // response observer
        StreamObserver<VirtualPetReply> response = new StreamObserver<VirtualPetReply>() {
            @Override
            public void onNext(VirtualPetReply v) {
                System.out.println("[SERVER REPLY] "
                        + "\nLevel: " + v.getLevel()
                        + "\nCredit: " + v.getPersonalCredit());
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("[SERVER ERROR] " + thrwbl.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("[SERVER COMPLETED]");
                latch.countDown();
            }

        };
        // send request 
        virtualPetStub.getPetStatus(request, response);

        boolean finished = latch.await(5, TimeUnit.SECONDS);
        if (!finished) {
            System.out.println("[TIMEOUT] Server did not complete within 5 seconds.");
        }
    }

    public void activityTrackTest(List<ActivityRequest> request) throws Exception {
        System.out.println("Client-streaming - activityTrack test");

        // countDown
        CountDownLatch latch = new CountDownLatch(1);

        // set reply straeam - output
        StreamObserver<ActivityReply> responseObserver = new StreamObserver<ActivityReply>() {
            @Override
            public void onNext(ActivityReply v) {
                System.out.println("Server reply DAY = " + v.getDay()
                        + "\ntotalCredit: " + v.getPersonalCredit().getTotalCredit());
            }

            @Override
            public void onError(Throwable thrwbl) {
                System.out.println("Server ERROR: " + thrwbl.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Server COMPLETED");
                latch.countDown();
            }

        };
        // set request stream - input
        StreamObserver<ActivityRequest> trackActivity = activityTrackStub.trackActivity(responseObserver);
        try {
            for (ActivityRequest req : request) {
                trackActivity.onNext(req);
            }
            // close 
            trackActivity.onCompleted();
        } catch (RuntimeException e) {
            trackActivity.onError(e);
            throw e;
        }

        latch.await(5, TimeUnit.SECONDS);

    }

    public void productTrack(List<String> productId) throws InterruptedException {
        System.out.println("Bi-directional - productTrack test");

        CountDownLatch latch = new CountDownLatch(1);

        StreamObserver<ProductReply> responseObserver = new StreamObserver<ProductReply>() {
            @Override
            public void onNext(ProductReply reply) {
                System.out.println("[SERVER REPLY] productId=" + reply.getProductId()
                        + ", manufacturer=" + reply.getManufacturer()
                        + ", description=" + reply.getDescription()
                        + ", carbon=" + reply.getCarbon()
                        + ", impactPoint=" + reply.getImpactPoint());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("[SERVER ERROR] " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("[SERVER COMPLETED]");
                latch.countDown();
            }
        };

        StreamObserver<ProductRequest> requestObserver = productServiceStub.purchaseTrack(responseObserver);

        try {
            for (String id : productId) {
                System.out.println("[CLIENT SEND] productId=" + id);
                requestObserver.onNext(ProductRequest.newBuilder().setProductId(id).build());
            }
        } catch (RuntimeException e) {
            requestObserver.onError(e);
            throw e;
        }

        // Tell server: client is done
        requestObserver.onCompleted();

        // wait for server returns
        boolean finished = latch.await(5, TimeUnit.SECONDS);
        if (!finished) {
            System.out.println("[TIMEOUT] Server did not complete within 5 seconds.");
        }

    }

    public void shutdown() {
        if (channel != null) {
            channel.shutdown();
        }
    }

    public boolean loginfunction(String id, String password) {

        try {

            LoginRequest loginRequest = LoginRequest.newBuilder().setId(id).setPassword(password).build();

            LoginResponse loginResponse = loginStub.loginSystem(loginRequest);

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
}
