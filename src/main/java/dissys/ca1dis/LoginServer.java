/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dissys.ca1dis;
// tools

import generated.grpc.loginService.LoginRequest;
import generated.grpc.loginService.LoginResponse;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

import generated.grpc.loginService.LoginServiceGrpc.LoginServiceImplBase;
import generated.grpc.loginService.LogoutRequest;
import generated.grpc.loginService.LogoutResponse;
import io.grpc.stub.StreamObserver;
import generated.grpc.loginService.Confirmation;

// DB class
import data.manager.AccountManager;

// jmdns
import jmdns.ServiceRegistration;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

import java.util.logging.Logger;

/**
 *
 * @author brad1109
 */
public class LoginServer extends LoginServiceImplBase {
    
    // single register for testing
    public static void main(String[] args){
        Logger logger = Logger.getLogger(LoginServer.class.getName());
        // intance class
        LoginServer loginServer = new LoginServer();
        int port = 50051;
        try{
            // Create Server 
            Server server = ServerBuilder.forPort(port).addService(loginServer).build().start();
            
            logger.info("Server started, listening on " + port);
            server.awaitTermination();
        }catch(IOException e){
            e.printStackTrace();
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    
    }

    // method
    // wrap Confirmation including boolean result and String message
    @Override
    public void loginSystem(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        System.out.println("Recived login request");

        // Instantial DB class
        AccountManager am = new AccountManager();

        String userId = request.getId();
        String UserPassword = request.getPassword();

        boolean flag = am.validate(userId, UserPassword);
        // set confirmation
        Confirmation conf;
        if (flag) {
            conf = Confirmation.newBuilder().setResult(true).setMessage("Login success.").build();
        } else {
            conf = Confirmation.newBuilder().setResult(false).setMessage("Login error.").build();
        }

        // set login Reply
        LoginResponse reply = LoginResponse.newBuilder().setConfirmation(conf).build();

        // complete
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }

    // In version1; didn't use it.
        @Override
    public void logoutSystem(LogoutRequest request, StreamObserver<LogoutResponse> responseObserver) {
        System.out.println("Recived logout request");

        Confirmation conf = Confirmation.newBuilder().setResult(true).setMessage("Logout success.").build();

        // reply
        LogoutResponse reply = LogoutResponse.newBuilder().setConfirmation(conf).build();

        // complete
        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}
