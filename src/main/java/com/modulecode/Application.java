package com.modulecode;

import com.modulecode.net.IRequest;
import com.modulecode.net.impl.BaseRouter;
import com.modulecode.net.impl.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Application {
    private static Logger logger = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        var server = new Server("");
        //2 Configure user-defined routes and services
        server.addRouter(0, new PingRouter());
        //3 Start the service
        server.serve();
    }

}


class PingRouter extends BaseRouter {
    HashMap<String, String> keyword = new HashMap<>();
    ArrayList keys = new ArrayList();

    public PingRouter() {
        keyword.put("机器人", "我不是机器人");
        keyword.put("6", "你6个头");
        keyword.put("傻逼", "6");
        keyword.put("SB", "妈的你和谁说话呢?");
        Set<String> strings = keyword.keySet();
        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            keys.add(iterator.next());
        }
    }

    @Override
    public void preHandle(IRequest request) throws IOException {


        byte[] data = request.getData();
        String str = new String(data, "utf-8");
        System.out.println(str);
        keys.forEach(key -> {
            String returnText = keyword.get(key);
            if (str.contains(key.toString())) {
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(request.getConnection().getTCPSocket().getOutputStream());
                    dataOutputStream.writeInt(returnText.getBytes(StandardCharsets.UTF_8).length);
                    dataOutputStream.write(returnText.getBytes());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

//        IConnection connection = request.getConnection();
//        connection.getTCPSocket().getOutputStream().write("preHandle\n".getBytes());
    }

    @Override
    public void handle(IRequest request) throws IOException {
//        byte[] data = request.getData();
//        String binary = binary(data, 2);
//        IConnection connection = request.getConnection();
//        DataOutputStream dataOutputStream = new DataOutputStream(connection.getTCPSocket().getOutputStream());
//        dataOutputStream.writeInt(binary.getBytes(StandardCharsets.UTF_8).length);
//        dataOutputStream.write(binary.getBytes());
    }

    /**
     * 将byte[]转为各种进制的字符串
     *
     * @param bytes byte[]
     * @param radix 基数可以转换进制的范围，从Character.MIN_RADIX到Character.MAX_RADIX，超出范围后变为10进制
     * @return 转换后的字符串
     */
    public String binary(byte[] bytes, int radix) {
        return new BigInteger(1, bytes).toString(radix);// 这里的1代表正数
    }

    @Override
    public void postHandle(IRequest request) throws IOException {
//        IConnection connection = request.getConnection();
//        connection.getTCPSocket().getOutputStream().write("postHandle\n".getBytes());
    }
}

