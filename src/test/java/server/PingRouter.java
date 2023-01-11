package server;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;
import com.modulecode.net.impl.BaseRouter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PingRouter extends BaseRouter {
    @Override
    public void preHandle(IRequest request) throws IOException {
        IConnection connection = request.getConnection();
        connection.getTCPSocket().getOutputStream().write("preHandle\n".getBytes());
    }

    @Override
    public void handle(IRequest request) throws IOException {
//        IConnection connection = request.getConnection();
//        connection.getTCPSocket().getOutputStream().write("handle\n".getBytes());
    }

    @Override
    public void postHandle(IRequest request) throws IOException {
//        IConnection connection = request.getConnection();
//        connection.getTCPSocket().getOutputStream().write("postHandle\n".getBytes());
    }
}
