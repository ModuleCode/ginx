package server;

import com.modulecode.net.IRequest;
import com.modulecode.net.impl.BaseRouter;
import com.modulecode.utils.JacksonUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class MessageRouter extends BaseRouter {
    @Override
    public void handle(IRequest request) throws IOException {

        String jsonData = request.getString("utf-8");
        Message message = JacksonUtils.json2Bean(jsonData, Message.class);
        System.out.println(message);

        //发送消息
        request.getConnection().sendMsg(0, "无法发送消息".getBytes(StandardCharsets.UTF_8));
    }
}
