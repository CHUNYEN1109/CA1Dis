/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package userAndServer;
// tools

import dissys.ca1dis.*;
import java.util.logging.Logger;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import java.io.IOException;

// jmdns
import jmdns.ServiceRegistration;
import java.net.InetAddress;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceInfo;

/**
 *
 * @author brad1109
 */
public class RegisterServer {

    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(RegisterServer.class.getName());
        // Attribution
        int port = 50051;
        String name = "gameServers";
        String type = "_grpc._tcp.local.";
        String text = "services=ProductTrackService,LoginService,SustainableActivityService,VirtualPetService;version=1";
        // jmdns
        JmDNS jmdns = JmDNS.create(InetAddress.getLocalHost());

        // Multiple Services
        ProducttrackServer productTrackServer = new ProducttrackServer();
        LoginServer loginServer = new LoginServer();
        SustainableTrackServer sustainableTrackServer = new SustainableTrackServer();
        VirtualPetServer virtualPetServer = new VirtualPetServer();

        try {
            // Builde Server 
            Server server = ServerBuilder.forPort(port)
                    .addService(productTrackServer)
                    .addService(loginServer)
                    .addService(sustainableTrackServer)
                    .addService(virtualPetServer)
                    .build().start();
            // Register by jmdns 
            ServiceInfo info = ServiceInfo.create(type, name, port, text);
            jmdns.registerService(info);
            
            // As long as close jmdns
            Runtime.getRuntime().addShutdownHook(new Thread(() -> {
                try {
                    jmdns.unregisterAllServices();
                    jmdns.close();
                    
                    server.shutdown();
                } catch (IOException ignored) {
                }
            }));
            
            logger.info("RegisterServer started, listening on port: " + port);
            // keep running
            server.awaitTermination();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
