package com.modulecode.net.impl;

import com.modulecode.net.IMsgHandle;
import com.modulecode.net.IRequest;
import com.modulecode.net.IRouter;
import lombok.ToString;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;

@ToString
public class MsgHandle implements IMsgHandle {
    private static final Logger logger = LogManager.getLogger(MsgHandle.class);
    HashMap<Integer, IRouter> routers = new HashMap<>();

    @Override
    public int getHandlerCount() {
        return routers.size();
    }

    @Override
    public void doMsgHandler(IRequest request) throws IOException {
        int msgID = request.getMsgID();
        IRouter iRouter = routers.get(msgID);
        if (iRouter != null) {
            iRouter.preHandle(request);
            iRouter.handle(request);
            iRouter.postHandle(request);
        }
    }

    @Override
    public void addRouter(int msgID, IRouter router) {

        IRouter iRouter = this.routers.get(msgID);
        if (iRouter == null) {
            routers.put(msgID, router);
            logger.info("接口 {} 添加成功!", router);
            return;
        }
        logger.warn("接口 {} 已经被注册!", msgID);


    }

    @Override
    public void startWorkerPool() {

    }

    @Override
    public void sendMsgToTaskQueue(IRequest request) {

    }
}
