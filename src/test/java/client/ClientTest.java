package client;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class ClientTest {
    @Test
    public void testConnectToServer() throws IOException {
        Socket socket = new Socket("127.0.0.1", 8999);
        String str = "hello";
        byte[] buf = new byte[10];
        try {
            for (; ; ) {
                System.out.println(socket.getInputStream().available());
                socket.getOutputStream().write("hello".getBytes(StandardCharsets.UTF_8));
                socket.getInputStream().read(buf);
                System.out.println(new String(buf, StandardCharsets.UTF_8));
                Thread.sleep(1000);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testString() {
        byte[] buf = new byte[10];
        String s = new String(buf, StandardCharsets.UTF_8);
        System.out.println(s);

    }
}
