package client;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientTest {
//    @Test
//    public void testConnectToServer() throws IOException {
//        Socket socket = new Socket("127.0.0.1", 8999);
//        Scanner scanner = new Scanner(System.in);
//        try {
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//            for (; ; ) {
//                System.out.println("请输入：");
//                String str = scanner.next();
//                dataOutputStream.writeInt(str.getBytes(StandardCharsets.UTF_8).length);
//                socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
//                System.out.println("发送完成");
//                Thread.sleep(1000);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        Socket socket = new Socket("127.0.0.1", 8800);
//        Scanner scanner = new Scanner(System.in);
//        try {
//            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
//            Thread readThead = new Thread(
//                    () -> {
//                        try {
//                            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
//                            for (; ; ) {
//
//                                if (inputStream.available() > 0) {
//                                    int len = inputStream.readInt();
//                                    byte[] data = new byte[len];
//                                    inputStream.read(data);
//                                    System.out.println("返回内容:" + new String(data));
//                                }
//                            }
//                        } catch (IOException e) {
//                            throw new RuntimeException(e);
//                        }
//
//                    }
//            );
//            readThead.start();
//            for (; ; ) {
//                Thread.sleep(100);
//                System.out.println("请输入：");
//
//                String str = scanner.next();
//                dataOutputStream.writeInt(str.getBytes(StandardCharsets.UTF_8).length);
//                socket.getOutputStream().write(str.getBytes(StandardCharsets.UTF_8));
//
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Test
    public void testString() {
        byte[] buf = new byte[10];
        String s = new String(buf, StandardCharsets.UTF_8);
        System.out.println(s);

    }
}
