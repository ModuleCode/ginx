package server;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;

import java.nio.charset.StandardCharsets;

public class PingRouter implements IRouter {
    @Override
    public void preHandle(IRequest request) {

    }

    @Override
    public void handle(IRequest request) {
        IConnection connection = request.getConnection();
        request.getConnection().sendMsg(0, "HelloWorld".getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void postHandle(IRequest request) {

    }
}
