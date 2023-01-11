package com.modulecode.net.impl;

import com.modulecode.net.IConnection;
import com.modulecode.net.IRouter;
import com.modulecode.net.funcs.HandleFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;

public class Connection implements IConnection {
    private static final Logger logger = LogManager.getLogger(Connection.class);
    Socket conn;
    int connid;
    boolean isClosed;


    //告诉当前连接已经退出/停止
    boolean exitChan;

    //当前处理的router
    IRouter router;

    @Override
    public void start() {
        logger.info("Conn start().. connid= {}", connid);
        //启动当前连接的读数据业务
        new Thread(() -> {
            try {
                startReader();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();


    }

    private void startReader() throws IOException {
        logger.info("Reader is running...");
        for (; ; ) {
            byte[] bytes = new byte[10];
            //从路由，找到绑定的对应 router
            Request request = new Request(this, bytes);

            //执行注册的路由方法
            this.router.preHandle(request);
            this.router.handle(request);
            this.router.postHandle(request);
//            int len = conn.getInputStream().read(bytes);
//            handleAPI.handle(conn, bytes, len);
        }


    }

    @Override
    public void stop() throws IOException {
        logger.info("Conn stop().. connid= {}", connid);
        //如果连接已经关闭
        if (isClosed) {
            return;
        }
        isClosed = true;

        //关闭socket连接
        conn.close();
    }

    @Override
    public Socket getTCPSocket() {
        return null;
    }

    @Override
    public int getConnID() {
        return 0;
    }

    @Override
    public Inet4Address remoteAddr() {
        return null;
    }

    @Override
    public void sendMsg(int msgid, byte[] data) {

    }

    @Override
    public void setProperty(String key, Object value) {

    }

    @Override
    public Object getProperty(String key) {
        return null;
    }

    @Override
    public void removeProperty(String key) {

    }

    public Connection(Socket conn, int connid, IRouter router) {
        this.conn = conn;
        this.connid = connid;
        this.router = router;
        this.isClosed = false;
        this.exitChan = false;
    }
}

