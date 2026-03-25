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

    // constructor
    ClientTest(String name, int port) {
        // build channel
        channel = ManagedChannelBuilder.forAddress(name, port).usePlaintext().build();
        // wrap stub into chanell
        loginStub = LoginServiceGrpc.newBlockingStub(channel);
        productServiceStub = ProductTrackGrpc.newStub(channel);
    }

    public static void main(String[] args) throws Exception {
        // ClientTest instance
        ClientTest clientTest = new ClientTest("localhost", 50051);
        //set a list of id
        List<String> ids = Arrays.asList("A01", "A02", "XXX_NOT_EXIST", "A03");
        // invoke
        clientTest.productTrack(ids);

        clientTest.shutdown();

    }

    public void productTrack(List<String> productId) throws InterruptedException{
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
