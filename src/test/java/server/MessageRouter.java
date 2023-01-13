package server;

import com.modulecode.net.IRequest;
import com.modulecode.net.impl.BaseRouter;
import com.modulecode.utils.JacksonUtils;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Cancellable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MessageRouter extends BaseRouter {
    private static final Logger logger = LogManager.getLogger(MessageRouter.class);


    @SneakyThrows
    @Override
    public void handle(IRequest request) throws IOException {
        String jsonData = request.getString("utf-8");
        Message message = JacksonUtils.json2Bean(jsonData, Message.class);
        System.out.println(message);
        String webMessage = getWebMessage(message.getMessage());
        logger.info(webMessage);
        request.getConnection().sendMsg(0, webMessage.getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public String getWebMessage(String message) {
        var url = new URL("http://api.qingyunke.com/api.php?key=free&appid=0&msg=" + message);
        InputStream is = url.openStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        return br.readLine();
    }

}
