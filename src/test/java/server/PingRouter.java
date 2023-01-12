package server;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;
import com.modulecode.net.impl.BaseRouter;
import com.modulecode.net.impl.Server;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.Inet4Address;
import java.net.SocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class PingRouter extends BaseRouter {
    private static final Logger logger = LogManager.getLogger(PingRouter.class);
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
        int connID = request.getConnection().getConnID();
        logger.info("connID:{} " + request.getString("utf-8"), connID);
        request.getConnection().sendMsg(1, "HelloWorld".getBytes(StandardCharsets.UTF_8));
//        System.out.println(request.getConnection().remoteAddr());
//        System.out.println(request.getMsgID());
//        System.out.println(request.getConnection().getConnID());
//        System.out.println(request.getData("utf-8"));
//        SocketAddress remoteSocketAddress = request.getConnection().getTCPSocket().getRemoteSocketAddress();
//        System.out.println(remoteSocketAddress);
//        byte[] data = request.getData();
//        String str = new String(data, "utf-8");
//        System.out.println(str);
//        keys.forEach(key -> {
//            String returnText = keyword.get(key);
//            if (str.contains(key.toString())) {
//                try {
//                    int id = 0;
//                    DataOutputStream dataOutputStream = new DataOutputStream(request.getConnection().getTCPSocket().getOutputStream());
//                    dataOutputStream.writeInt(returnText.getBytes(StandardCharsets.UTF_8).length);
//                    dataOutputStream.writeInt(id);
//                    dataOutputStream.write(returnText.getBytes());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });

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
