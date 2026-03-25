/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jmdns;




import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import javax.jmdns.JmDNS;
import javax.jmdns.ServiceEvent;
import javax.jmdns.ServiceInfo;
import javax.jmdns.ServiceListener;


//// This code is adapted from https://github.com/jmdns/jmdns
public class ServiceDiscovery {

    private String requiredServiceType;
    private String requiredServiceName;
    private JmDNS jmdns;
    private volatile ServiceInfo discoveredInfo;

    public ServiceDiscovery(String inServiceType, String inServiceName) {
        requiredServiceType = inServiceType;
        requiredServiceName = inServiceName;
    }

    // return ServiceIngo for gRPC
    public ServiceInfo discoverService(long timeoutMilliseconds) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);

        try {

            // Create a JmDNS instance
            this.jmdns = JmDNS.create(InetAddress.getLocalHost());
            System.out.println("Client: InetAddress.getLocalHost():" + InetAddress.getLocalHost());
            
            
            // Add a service listener that listens for the required service type on localhost
            jmdns.addServiceListener(requiredServiceType, new ServiceListener() {

                @Override
                public void serviceAdded(ServiceEvent event) {
                    ServiceInfo info = event.getInfo();
                    System.out.println("Service added: " + event.getInfo());
                }

                @Override
                public void serviceRemoved(ServiceEvent event) {
                    System.out.println("Service removed: " + event.getInfo());
                }

                @Override
                public void serviceResolved(ServiceEvent event) {
                    System.out.println("Service resolved: " + event.getInfo());
                    ServiceInfo info = event.getInfo();
                    int port = info.getPort();
                    String resolvedServiceName = info.getName();

                    System.out.println("####service " + resolvedServiceName + " resolved at: " + port);

                    // check if the name of the service is the one we are looking for - if not we
                    // just ignore it.
                    if (resolvedServiceName.contains(requiredServiceName)) {
                        // the Service information that was discovered is passed onto the HttpClient
                        System.out.println("Discovered service named: " + resolvedServiceName);
                       

                         // the event we were waiting for has happened. Release the latch. 
                         discoveredInfo = info;
                         latch.countDown(); 
                    }
                   
                }
            });

        } catch (UnknownHostException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        // if there was no service resolved of the required type latch will timeoout
        // check if it success
        boolean flag = latch.await(timeoutMilliseconds, TimeUnit.MILLISECONDS);
        if(!flag) return null;
        return discoveredInfo;
    }
    
    public void close ( ) throws IOException {
        if (jmdns != null) {
            jmdns.close();
        }
    }

}


