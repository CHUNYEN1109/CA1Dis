/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dissys.ca1dis;
// tools
import io.grpc.stub.StreamObserver;

import generated.grpc.loginService.LoginRequest;
import generated.grpc.loginService.LoginResponse;

// LoginService
import generated.grpc.loginService.LoginServiceGrpc.LoginServiceImplBase;
import generated.grpc.loginService.LogoutRequest;
import generated.grpc.loginService.LogoutResponse;
import generated.grpc.loginService.Confirmation;

// DB class
import data.manager.AccountManager;



/**
 *
 * @author brad1109
 */
public class LoginServer extends LoginServiceImplBase {
    


    // Return: None
    // Parameters: LoginRequest, StreamObserver<LoginResponse>
    // wrap Confirmation including boolean result and String message
    @Override
    public void loginSystem(LoginRequest request, StreamObserver<LoginResponse> responseObserver) {
        System.out.println("Recived login request");

        // Instantial DB class
        AccountManager am = new AccountManager();

        //Receive quest from client and extract data from request
        String userId = request.getId();
        String UserPassword = request.getPassword();

        // Process
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
