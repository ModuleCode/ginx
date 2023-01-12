package server;

import com.modulecode.net.impl.Server;
import org.junit.Test;

public class ServerTest {
    @Test
    public void testServer() {
        //1 Create the server object
        var server = new Server();
        //2 Configure user-defined routes and services
        server.addRouter(0, new PingRouter());
        server.addRouter(1, new LoginRouter());
        server.addRouter(2, new MessageRouter());
        //3 Start the service
        server.serve();
    }
}
