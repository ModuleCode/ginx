package com.modulecode.net;

import lombok.ToString;

import java.io.IOException;

/**
 * 提供worker启动、处理消息业务调用等接口
 */

public interface IMsgHandle {
    int getHandlerCount();

    void doMsgHandler(IRequest request) throws IOException;          //马上以非阻塞方式处理消息

    void addRouter(int msgID, IRouter router); //为消息添加具体的处理逻辑

    void startWorkerPool();                       //启动worker工作池

    void sendMsgToTaskQueue(IRequest request);    //将消息交给TaskQueue,由worker进行处理
}
