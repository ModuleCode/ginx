package server;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;
import com.modulecode.net.impl.BaseRouter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class PingRouter extends BaseRouter {
    @Override
    public void preHandle(IRequest request) throws IOException {


//        IConnection connection = request.getConnection();
//        connection.getTCPSocket().getOutputStream().write("preHandle\n".getBytes());
    }

    @Override
    public void handle(IRequest request) throws IOException {
        byte[] data = request.getData();
        String binary = binary(data, 2);
        IConnection connection = request.getConnection();
        DataOutputStream dataOutputStream = new DataOutputStream(connection.getTCPSocket().getOutputStream());
        dataOutputStream.writeInt(binary.getBytes(StandardCharsets.UTF_8).length);
        dataOutputStream.write(binary.getBytes());
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
